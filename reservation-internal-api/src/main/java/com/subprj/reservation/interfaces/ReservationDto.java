package com.subprj.reservation.interfaces;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ReservationDto {

    @ToString
    @Builder
    @Setter
    @Getter
    public static class ResponseHistory {
        private String startDate;
        private String endDate;
        private String reservationId;
        private String roomId;
        private String hotelId;
    }
}
