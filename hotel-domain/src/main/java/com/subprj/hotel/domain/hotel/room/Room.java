package com.subprj.hotel.domain.hotel.room;

import com.subprj.hotel.domain.hotel.Hotel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Room {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomTypeId;
    private Long floor;
    private Long number;

    @JoinColumn(name = "hotel_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel hotel;
    private String name;
    private Boolean isAvailable;

    @Builder
    public Room(Long floor, Long number,
                Hotel hotel, String name, Boolean isAvailable) {
        this.roomTypeId = UUID.randomUUID().toString().substring(0,10);
        this.floor = floor;
        this.number = number;
        this.hotel = hotel;
        this.name = name;
        this.isAvailable = isAvailable;
    }
}
