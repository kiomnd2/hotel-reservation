package com.subprj.hotel.domain.hotel;

import ch.qos.logback.classic.spi.LoggingEventVO;
import com.subprj.hotel.domain.hotel.room.Room;
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

    @Builder
    @Getter
    public static class PutHotelRoom {
        private String name;
        private Long floor;
        private Long number;
        private Boolean isAvailable;

        public Room toEntity() {
            return Room.builder()
                    .name(name)
                    .floor(floor)
                    .number(number)
                    .isAvailable(isAvailable)
                    .build();
        }
    }
}
