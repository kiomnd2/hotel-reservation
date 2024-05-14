package com.subprj.reservation.domain;

import lombok.Builder;
import lombok.Getter;

public class ReservationCommand {

    @Builder
    @Getter
    public static class CreateReservation {
        private String hotelId;
        private String roomTypeId;
        private String date;
        private Integer totalInventory;
        private Integer totalReservation;

        public Reservation toEntity() {
            return Reservation.builder()
                    .hotelId(hotelId)
                    .roomTypeId(roomTypeId)
                    .date(date)
                    .totalInventory(totalInventory)
                    .totalReservation(totalReservation)
                    .build();
        }
    }
}
