package com.subprj.hotel.domain.hotel;

import com.subprj.hotel.domain.hotel.room.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Hotel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;
    private String name;
    private String address;
    private Boolean isDelete;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
    private List<Room> roomList;

    @Builder
    public Hotel(String name, String address) {
        this.uuid = UUID.randomUUID().toString().substring(0,10);;
        this.name = name;
        this.address = address;
        this.isDelete = false;
    }

    public HotelInfo toInfo() {
        return HotelInfo.builder()
                .name(name)
                .address(address)
                .build();
    }

    public void put(HotelCommand.PutHotel command) {
        this.name = command.getName();
        this.address = command.getAddress();
    }

    public void deleteHotel() {
        this.isDelete = true;
    }
}
