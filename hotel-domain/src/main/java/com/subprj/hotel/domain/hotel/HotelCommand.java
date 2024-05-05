package com.subprj.hotel.domain.hotel;

import lombok.Builder;
import lombok.Getter;

public class HotelCommand {

    @Builder
    @Getter
    public static class PutHotel {
        private String name;
        private String address;

        public Hotel toEntity() {
            return Hotel.builder()
                    .name(name)
                    .address(address)
                    .build();
        }
    }
}
