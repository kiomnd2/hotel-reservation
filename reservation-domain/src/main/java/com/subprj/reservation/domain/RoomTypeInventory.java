package com.subprj.reservation.domain;

import com.subprj.common.InvalidHotelInfoException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class RoomTypeInventory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;
    private String hotelId;
    private String roomTypeId;
    private LocalDateTime date;
    private Integer totalInventory;
    private Integer totalReservation;

    @Builder
    public RoomTypeInventory(String hotelId, String roomTypeId, String date, Integer totalInventory, Integer totalReservation) {
        this.uuid = UUID.randomUUID().toString().substring(0, 10);
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
        this.date = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.totalInventory = totalInventory;
        this.totalReservation = totalReservation;
    }

    public void valid(ReservationValidator reservationValidator) {
        if (!reservationValidator.validHotel(this.getHotelId(), this.getRoomTypeId())) {
            throw new InvalidHotelInfoException(this.getHotelId(), this.getRoomTypeId());
        }
    }

    public RoomTypeInventoryInfo toInfo() {
        return RoomTypeInventoryInfo.builder()
                .hotelId(hotelId)
                .roomTypeId(roomTypeId)
                .date(date)
                .totalInventory(totalInventory)
                .totalReservation(totalReservation)
                .build();
    }

    public boolean checkRoomInventory(int numberOfRoomReserve) {
        // 예약의 10퍼센트 초과까지 받음
        if (this.totalReservation + numberOfRoomReserve <= totalInventory * 1.1) {
            return true;
        }
        return false;
    }
}
