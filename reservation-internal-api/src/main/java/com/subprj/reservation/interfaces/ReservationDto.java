package com.subprj.reservation.interfaces;

import com.subprj.reservation.domain.ReservationCommand;
import com.subprj.reservation.domain.RoomTypeInventoryInfo;
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
    public static class ResponseCreateRoomInventory {
        private String hotelId;
        private String roomTypeId;
        private String date;
        private Integer totalInventory;
        private Integer totalReservation;

        public static List<ResponseCreateRoomInventory> byInfo(List<RoomTypeInventoryInfo> reservationsRoom) {
            return reservationsRoom.stream()
                    .map(ResponseCreateRoomInventory::byInfo).collect(Collectors.toList());
        }

        public static ResponseCreateRoomInventory byInfo(RoomTypeInventoryInfo reservationInfo) {
            return ResponseCreateRoomInventory.builder()
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
    public static class RequestRegisterRoomTypeInventory {
        private String hotelId;
        private String roomTypeId;
        private String date;
        private Integer totalInventory;
        private Integer totalReservation;

        public ReservationCommand.CreateRoomTypeInventory toCommand() {
            return ReservationCommand.CreateRoomTypeInventory.builder()
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

    @Getter
    @Setter
    @ToString
    @Builder
    public static class ResponseReservation {
        private Boolean isReservation;
    }

    @Getter
    @Setter
    @ToString
    public static class RequestReservation {
        private String startDate;
        private String endDate;
        private String reservationId;
        private String roomId;
        private String hotelId;

        public ReservationCommand.CreateReservation toCommand() {
            return ReservationCommand.CreateReservation.builder()
                    .startDate(startDate)
                    .endDate(endDate)
                    .reservationId(reservationId)
                    .roomId(roomId)
                    .hotelId(hotelId)
                    .build();
        }
    }
}
