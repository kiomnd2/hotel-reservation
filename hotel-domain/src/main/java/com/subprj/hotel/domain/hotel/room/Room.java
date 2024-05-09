package com.subprj.hotel.domain.hotel.room;

import com.subprj.hotel.domain.hotel.Hotel;
import com.subprj.hotel.domain.hotel.HotelCommand;
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
    private boolean isDelete;

    @Builder
    public Room(Long floor, Long number,
                Hotel hotel, String name, Boolean isAvailable) {
        this.roomTypeId = UUID.randomUUID().toString().substring(0,10);
        this.floor = floor;
        this.number = number;
        this.hotel = hotel;
        this.name = name;
        this.isAvailable = isAvailable;
        this.isDelete = false;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void modifyHotelRoom(HotelCommand.PutHotelRoom hotelRoom) {
        this.name = hotelRoom.getName();
        this.floor = hotelRoom.getFloor();
        this.isAvailable = hotelRoom.getIsAvailable();
        this.number = hotelRoom.getNumber();
    }

    public RoomInfo toInfo() {
        return RoomInfo.builder()
                .name(name)
                .roomTypeId(roomTypeId)
                .number(number)
                .floor(floor)
                .isAvailable(isAvailable)
                .build();
    }

    public void delete() {
        this.isDelete = true;
    }
}
