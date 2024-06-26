package com.subprj.reservation.domain;

import com.subprj.reservation.infrastructure.RoomTypeCacheInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationValidator reservationValidator;
    private final RoomTypeInventoryStore roomTypeInventoryStore;
    private final RoomTypeInventoryReader roomTypeInventoryReader;
    private final ReservationRedissonLock redissonLock;
    private final ReservationStore reservationStore;
    private final ReservationReader reservationReader;
    private final RoomTypeCacheInventoryRepository roomTypeCacheInventoryRepository;

    @Transactional
    public String registerRoomTypeInventory(ReservationCommand.CreateRoomTypeInventory request) {
        RoomTypeInventory roomTypeInventory = request.toEntity();
        roomTypeInventory.valid(reservationValidator);

        return roomTypeInventoryStore.store(roomTypeInventory).getUuid();
    }

    @Transactional
    public List<RoomTypeInventoryInfo> getRoomTypeBetweenDate(String startDate, String endDate) {
        return roomTypeInventoryReader.read(startDate, endDate).stream()
                .map(RoomTypeInventory::toInfo).collect(Collectors.toList());
    }

    @Transactional
    public boolean reservation(ReservationCommand.CreateReservation command) {

        if (!reservationReader.checkReservation(command.getReservationId())) {
            reservationStore.store(command.toEntity());
        }
        // lock 걸어야 함

        return redissonLock.lock(command.getReservationId(), () -> {
            if (reservationValidator.checkReservation(command, roomTypeInventoryReader)) {
                List<RoomTypeInventoryCache> inventoryList = roomTypeInventoryReader.readCache(command.getHotelId(), command.getRoomId()
                        , command.getStartDate(), command.getEndDate());
                inventoryList.forEach(v -> roomTypeCacheInventoryRepository.save(v.reservation(command.getNumberOfRoomReserve())));
                return true;
            }
            return false;
        });
    }
}
