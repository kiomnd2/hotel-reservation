package com.subprj.hotel.domain.hotel.room;

import com.subprj.hotel.domain.hotel.Hotel;

public interface RoomReader {
    Room read(Hotel hotel, String roomId);
}
