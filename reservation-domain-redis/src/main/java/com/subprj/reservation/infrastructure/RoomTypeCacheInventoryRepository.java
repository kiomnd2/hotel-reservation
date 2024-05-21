package com.subprj.reservation.infrastructure;

import com.subprj.reservation.domain.RoomTypeInventoryCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomTypeCacheInventoryRepository extends CrudRepository<RoomTypeInventoryCache, String> {
    List<RoomTypeInventoryCache> findAllByReserveDateBetweenAndHotelIdAndRoomTypeId(LocalDateTime startDate, LocalDateTime endDate,
                                                                                    String hotelId, String roomTypeId);
}
