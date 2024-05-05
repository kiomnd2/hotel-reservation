package com.subprj.hotel.infrastructure.hotel.room;

import com.subprj.hotel.domain.hotel.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
