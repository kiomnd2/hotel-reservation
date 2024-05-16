package com.subprj.reservation.infrastructure;

import com.subprj.common.utils.DateTimeUtil;
import com.subprj.reservation.domain.RoomTypeInventory;
import com.subprj.reservation.domain.RoomTypeInventoryReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ReservationReaderImpl implements RoomTypeInventoryReader {
    private final RoomTypeInventoryRepository roomTypeInventoryRepository;
    @Override
    public List<RoomTypeInventory> read(String startDate, String endDate) {
        return roomTypeInventoryRepository.findAllByDateBetween(
                DateTimeUtil.toLocalDateTime(startDate),
                DateTimeUtil.toLocalDateTime(endDate)
        );
    }

    @Override
    public List<RoomTypeInventory> read(String hotelId, String roomId,
                                        String startDate, String endDate) {
        return roomTypeInventoryRepository.findAllByDateBetweenAndHotelIdAndRoomTypeId(
                DateTimeUtil.toLocalDateTime(startDate),
                DateTimeUtil.toLocalDateTime(endDate),
                hotelId,
                roomId
        );
    }
}
