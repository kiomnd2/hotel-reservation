package com.subprj.hotel.domain.hotel;

import lombok.Builder;
import lombok.Getter;

@Getter
public class HotelInfo {
    private final String name;
    private final String address;

    @Builder
    public HotelInfo(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
