package com.subprj.reservation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reservationId;
    private String hotelId;
    private String roomTypeId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Status status;
    private String guestId;

    public enum Status {
        PENDING, PAID, REFUNDED, CANCELED, REJECTED
    }

    @Builder
    public Reservation(String reservationId, String hotelId, String roomTypeId, LocalDateTime startDate,
                       LocalDateTime endDate, Status status, String guestId) {
        this.reservationId = reservationId;
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = Status.PENDING;
        this.guestId = guestId;
    }
}
