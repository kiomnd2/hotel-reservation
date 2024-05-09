package com.subprj.hotel.domain.hotel;

import com.subprj.hotel.domain.hotel.room.Room;
import com.subprj.hotel.domain.hotel.room.RoomInfo;
import com.subprj.hotel.domain.hotel.room.RoomReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class HotelService {
    private final HotelStore hotelStore;
    private final HotelReader hotelReader;
    private final RoomReader roomReader;

    public HotelInfo getHotel(String uuid) {
        return hotelReader.read(uuid).toInfo();
    }

    public HotelInfo saveHotel(HotelCommand.PutHotel command) {
        return hotelStore.store(command.toEntity()).toInfo();
    }

    @Transactional
    public void modifyHotel(String hotelId, HotelCommand.PutHotel command) {
        Hotel read = hotelReader.read(hotelId);
        read.put(command);
    }

    @Transactional
    public void deleteHotel(String hotelId) {
        Hotel read = hotelReader.read(hotelId);
        read.deleteHotel();
    }

    public RoomInfo getHotelRoom(String hotelId, String roomId) {
        Hotel hotel = hotelReader.read(hotelId);
        Room room = roomReader.read(hotel, roomId);
        return room.toInfo();
    }

    @Transactional
    public String addHotelRoom(String hotelId, HotelCommand.PutHotelRoom command) {
        Hotel hotel = hotelReader.read(hotelId);
        Room room = command.toEntity();
        hotel.addRoom(room);
        return room.getRoomTypeId();
    }

    @Transactional
    public void modifyHotelRoom(String hotelId, String roomId, HotelCommand.PutHotelRoom hotelRoom) {
        Hotel hotel = hotelReader.read(hotelId);
        Room room = roomReader.read(hotel, roomId);
        room.modifyHotelRoom(hotelRoom);
    }

    @Transactional
    public void deleteHotelRoom(String hotelId, String roomId) {
        Hotel hotel = hotelReader.read(hotelId);
        Room room = roomReader.read(hotel, roomId);
        room.delete();
    }
}
