package com.subprj.reservation.domain;

import com.subprj.common.utils.DateTimeUtil;
import lombok.Builder;
import lombok.Getter;

public class ReservationCommand {

    @Builder
    @Getter
    public static class CreateRoomTypeInventory {
        private String hotelId;
        private String roomTypeId;
        private String date;
        private Integer totalInventory;
        private Integer totalReservation;

        public RoomTypeInventory toEntity() {
            return RoomTypeInventory.builder()
                    .hotelId(hotelId)
                    .roomTypeId(roomTypeId)
                    .date(date)
                    .totalInventory(totalInventory)
                    .totalReservation(totalReservation)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class CreateReservation {
        private String startDate;
        private String endDate;
        private String reservationId;
        private String roomId;
        private String hotelId;
        private Integer numberOfRoomReserve;
        public Reservation toEntity() {
            return Reservation.builder()
                    .startDate(DateTimeUtil.toLocalDateTime(startDate))
                    .endDate(DateTimeUtil.toLocalDateTime(endDate))
                    .reservationId(reservationId)
                    .roomTypeId(roomId)
                    .hotelId(hotelId)
                    .build();
        }
    }
}
