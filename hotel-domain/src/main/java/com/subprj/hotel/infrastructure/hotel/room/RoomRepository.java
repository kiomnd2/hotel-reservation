package com.subprj.hotel.infrastructure.hotel.room;

import com.subprj.hotel.domain.hotel.Hotel;
import com.subprj.hotel.domain.hotel.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByHotelAndRoomTypeId(Hotel hotel, String roomId);
}
