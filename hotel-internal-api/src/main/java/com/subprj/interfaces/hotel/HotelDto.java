package com.subprj.interfaces.hotel;

import com.subprj.hotel.domain.hotel.HotelCommand;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class HotelDto {

    @Getter
    @Setter
    @ToString
    public static class RequestRegisterHotel {
        private String name;
        private String address;

        public HotelCommand.PutHotel toCommand() {
            return HotelCommand.PutHotel.builder()
                    .name(name)
                    .address(address)
                    .build();
        }
    }

    @Getter
    @Builder
    @ToString
    public static class ResponseRegister {
        private String token;
    }

    @Getter
    @Builder
    @ToString
    public static class ResponseHotelInfo {
        private String name;
        private String address;
    }
}
