package com.subprj.reservation.domain;

import com.subprj.hotel.domain.hotel.HotelService;
import com.subprj.hotel.domain.hotel.room.RoomInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ReservationValidatorImpl implements ReservationValidator {
    private final HotelService hotelService;

    @Override
    public boolean validHotel(String hotelId, String roomTypeId) {
        try {
            hotelService.getHotelRoom(hotelId, roomTypeId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkReservation(ReservationCommand.CreateReservation command,
                                    RoomTypeInventoryReader roomTypeInventoryReader) {
        RoomInfo hotelRoom = hotelService.getHotelRoom(command.getHotelId(), command.getRoomId());
        if (hotelRoom.getIsAvailable()) {
            List<RoomTypeInventory> inventory =
                    roomTypeInventoryReader.read(command.getHotelId(), command.getRoomId(),
                            command.getStartDate(), command.getEndDate());
            // 인벤토리가 하나라도 없으면 false
            return inventory.stream()
                    .allMatch(roomTypeInventory -> roomTypeInventory.checkRoomInventory(command.getNumberOfRoomReserve()));
        }
        return true;
    }


}
