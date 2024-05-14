package com.subprj.reservation.domain;

import com.subprj.hotel.domain.hotel.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
}
