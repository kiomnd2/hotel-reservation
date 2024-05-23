package com.subprj.reservation.infrastructure;

import com.subprj.reservation.domain.RoomTypeInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RoomTypeInventoryRepository extends JpaRepository<RoomTypeInventory, Long> {
    List<RoomTypeInventory> findAllByDateBetween(LocalDate startDate, LocalDate endDate);
    List<RoomTypeInventory> findAllByDateBetweenAndHotelIdAndRoomTypeId(LocalDate startDate, LocalDate endDate
            , String hotelId, String roomId);
}
