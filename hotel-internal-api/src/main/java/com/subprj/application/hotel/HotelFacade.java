package com.subprj.application.hotel;

import com.subprj.hotel.domain.hotel.HotelCommand;
import com.subprj.hotel.domain.hotel.HotelInfo;
import com.subprj.hotel.domain.hotel.HotelService;
import com.subprj.interfaces.hotel.HotelDto;
import com.subprj.interfaces.hotel.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HotelFacade {
    private final HotelService hotelService;

    public String registerHotel(HotelDto.RequestRegisterHotel requestRegisterHotel) {
        return hotelService.saveHotel(requestRegisterHotel.toCommand()).getToken();
    }

    public HotelInfo getHotelInfo(String hotelId) {
        return hotelService.getHotel(hotelId);
    }

    public void updateHotel(String hotelId, HotelDto.RequestRegisterHotel updateHotel) {
        hotelService.modifyHotel(hotelId, updateHotel.toCommand());
    }

    public void deleteHotel(String hotelId) {
        hotelService.deleteHotel(hotelId);
    }

    public String addHotelRoom(String hotelId, RoomDto.RequestRoom requestRoom) {
        return hotelService.addHotelRoom(hotelId, HotelCommand.PutHotelRoom.builder()
                        .name(requestRoom.getName())
                        .floor(requestRoom.getFloor())
                        .number(requestRoom.getNumber())
                        .isAvailable(requestRoom.getIsAvailable())
                .build());
    }

    public void modifyHotelRoom(String hotelId, String roomId, RoomDto.RequestRoom requestRoom) {
        hotelService.modifyHotelRoom(hotelId, roomId, HotelCommand.PutHotelRoom.builder()
                .name(requestRoom.getName())
                .floor(requestRoom.getFloor())
                .number(requestRoom.getNumber())
                .isAvailable(requestRoom.getIsAvailable())
                .build());
    }

    public void deleteHotelRoom(String hotelId, String roomId) {
        hotelService.deleteHotelRoom(hotelId, roomId);
    }
}
