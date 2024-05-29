package com.subprj.interfaces.hotel;

import com.subprj.hotel.domain.hotel.Hotel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class RoomDto {

    @Getter
    @Setter
    @ToString
    public static class RequestRoom {
        private String name;
        private Long floor;
        private Long number;
        private Boolean isAvailable;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    public static class ResponseRoom {
        private Hotel hotelId;
        private String roomTypeId;
        private String name;
        private Long floor;
        private Long number;
        private Boolean isAvailable;

    }

    @Getter
    @Builder
    @ToString
    public static class ResponseToken {
        private String roomToken;
    }
}
