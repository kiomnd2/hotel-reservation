package com.subprj.hotel.infrastructure.hotel.room;

import com.subprj.hotel.common.response.exception.NotFoundHotelRoomException;
import com.subprj.hotel.domain.hotel.Hotel;
import com.subprj.hotel.domain.hotel.room.Room;
import com.subprj.hotel.domain.hotel.room.RoomReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoomReaderImpl implements RoomReader {
    private final RoomRepository roomRepository;
    @Override
    public Room read(Hotel hotel, String roomId) {
        return roomRepository.findByHotelAndRoomTypeId(hotel, roomId)
                .orElseThrow(NotFoundHotelRoomException::new);
    }
}
