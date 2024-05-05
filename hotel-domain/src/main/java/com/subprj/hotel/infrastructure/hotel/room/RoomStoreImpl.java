package com.subprj.hotel.infrastructure.hotel.room;

import com.subprj.hotel.domain.hotel.room.Room;
import com.subprj.hotel.domain.hotel.room.RoomStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoomStoreImpl implements RoomStore {
    private final RoomRepository roomRepository;
    @Override
    public Room store(Room room) {
        return roomRepository.save(room);
    }
}
