package com.subprj.reservation.domain;

import java.util.List;

public interface ReservationReader {
    List<Reservation> read(String startDate, String endDate);
}
