package com.subprj.reservation.interfaces;

import com.subprj.reservation.domain.ReservationCommand;
import com.subprj.reservation.domain.ReservationInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationDto {

    @ToString
    @Builder
    @Setter
    @Getter
    public static class ResponseReservation {
        private String hotelId;
        private String roomTypeId;
        private String date;
        private Integer totalInventory;
        private Integer totalReservation;

        public static List<ResponseReservation> byInfo(List<ReservationInfo> reservationsRoom) {
            return reservationsRoom.stream()
                    .map(ResponseReservation::byInfo).collect(Collectors.toList());
        }

        public static ResponseReservation byInfo(ReservationInfo reservationInfo) {
            return ResponseReservation.builder()
                    .hotelId(reservationInfo.getHotelId())
                    .roomTypeId(reservationInfo.getRoomTypeId())
                    .date(reservationInfo.getDate().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                    .totalReservation(reservationInfo.getTotalReservation())
                    .totalInventory(reservationInfo.getTotalInventory())
                    .build();
        }
    }

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
