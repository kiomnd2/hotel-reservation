package com.subprj.interfaces.hotel;

import com.subprj.hotel.domain.hotel.Hotel;
import com.subprj.hotel.domain.hotel.room.RoomInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class RoomDto {

    @Getter
    @Setter
    @ToString
    public static class RequestRoom {
        private Hotel hotelId;
        private String roomTypeId;
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

        public static ResponseRoom byInfo(RoomInfo roomInfo) {
            return ResponseRoom.builder()
                    .hotelId(roomInfo.getHotel())
                    .roomTypeId(roomInfo.getRoomTypeId())
                    .name(roomInfo.getName())
                    .floor(roomInfo.getFloor())
                    .number(roomInfo.getNumber())
                    .isAvailable(roomInfo.getIsAvailable())
                    .build();
        }
    }
}
