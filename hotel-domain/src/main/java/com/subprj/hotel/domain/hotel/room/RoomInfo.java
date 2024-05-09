package com.subprj.hotel.domain.hotel.room;

import com.subprj.hotel.domain.hotel.Hotel;
import lombok.Builder;
import lombok.Getter;


@Getter
public class RoomInfo {

    private final String roomTypeId;
    private final Long floor;
    private final Long number;
    private final Hotel hotel;
    private final String name;
    private final Boolean isAvailable;

    @Builder
    public RoomInfo(String roomTypeId, Long floor, Long number, Hotel hotel, String name, Boolean isAvailable) {
        this.roomTypeId = roomTypeId;
        this.floor = floor;
        this.number = number;
        this.hotel = hotel;
        this.name = name;
        this.isAvailable = isAvailable;
    }

}
