package com.subprj.reservation.domain;

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
        // lock 걸어야 함
        return redissonLock.lock(command.getReservationId(),
                () -> reservationValidator.checkReservation(command, roomTypeInventoryReader));
    }
}
