package com.subprj.reservation.interfaces;

import com.subprj.reservation.domain.ReservationCommand;
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

    @Getter
    @Setter
    @ToString
    public static class RequestRegister {
        private String hotelId;
        private String roomTypeId;
        private String date;
        private Integer totalInventory;
        private Integer totalReservation;

        public ReservationCommand.CreateReservation toCommand() {
            return ReservationCommand.CreateReservation.builder()
                    .hotelId(hotelId)
                    .roomTypeId(roomTypeId)
                    .date(date)
                    .totalInventory(totalInventory)
                    .totalReservation(totalReservation)
                    .build();
        }
    }

    @Getter
    @Setter
    @ToString
    @Builder
    public static class ResponseRegister {
        private String token;
    }
}
