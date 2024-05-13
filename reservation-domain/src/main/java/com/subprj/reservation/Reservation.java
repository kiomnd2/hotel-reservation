package com.subprj.reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;
    private String hotelId;
    private String roomTypeId;
    private LocalDateTime date;
    private Integer totalInventory;
    private Integer totalReservation;

    @Builder
    public Reservation(String hotelId, String roomTypeId, Integer totalInventory, Integer totalReservation) {
        this.uuid = UUID.randomUUID().toString().substring(0, 10);
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
        this.date = LocalDateTime.now();
        this.totalInventory = totalInventory;
        this.totalReservation = totalReservation;
    }
}
