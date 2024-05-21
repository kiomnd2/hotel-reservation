package com.subprj.reservation.infrastructure;

import com.subprj.common.utils.DateTimeUtil;
import com.subprj.reservation.domain.RoomTypeInventory;
import com.subprj.reservation.domain.RoomTypeInventoryCache;
import com.subprj.reservation.domain.RoomTypeInventoryReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Component
public class RoomTypeInventoryReaderImpl implements RoomTypeInventoryReader {
    private final RoomTypeInventoryRepository roomTypeInventoryRepository;
    private final RoomTypeCacheInventoryRepository cacheInventoryRepository;

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
        // 캐시 먼저 찾음
        LocalDateTime startDateTime = DateTimeUtil.toLocalDateTime(startDate);
        LocalDateTime endDateTime = DateTimeUtil.toLocalDateTime(endDate);
        return roomTypeInventoryRepository.findAllByDateBetweenAndHotelIdAndRoomTypeId(
                startDateTime,
                endDateTime,
                hotelId,
                roomId
        );
    }

    @Override
    public List<RoomTypeInventoryCache> readCache(String hotelId, String roomId, String startDate, String endDate) {
        LocalDateTime startDateTime = DateTimeUtil.toLocalDateTime(startDate);
        LocalDateTime endDateTime = DateTimeUtil.toLocalDateTime(endDate);

        return cacheInventoryRepository.findAllByReserveDateBetweenAndHotelIdAndRoomTypeId(
        startDateTime, endDateTime, hotelId, roomId);
    }
}
