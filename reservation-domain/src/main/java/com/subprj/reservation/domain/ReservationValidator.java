package com.subprj.reservation.domain;

public interface ReservationValidator {
    boolean validHotel(String hotelId, String roomTypeId);

}
