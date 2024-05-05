package com.subprj.interfaces.hotel;

import com.subprj.application.hotel.HotelFacade;
import com.subprj.common.resposne.CommonResponse;
import com.subprj.hotel.domain.hotel.HotelInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController("/v1/hotels")
public class HotelApi {
    private final HotelFacade hotelFacade;

    @GetMapping("/{hotelId}")
    public CommonResponse<HotelDto.ResponseHotelInfo> getHotel(@PathVariable String hotelId) {
        HotelInfo hotelInfo = hotelFacade.getHotelInfo(hotelId);
        return CommonResponse.success(HotelDto.ResponseHotelInfo.builder()
                .name(hotelInfo.getName())
                .address(hotelInfo.getAddress())
                .build());
    }

    @PostMapping
    public CommonResponse<HotelDto.ResponseRegister> registerHotel(@RequestBody HotelDto.RequestRegisterHotel registerHotel) {
        String token = hotelFacade.registerHotel(registerHotel);
        return CommonResponse.success(HotelDto.ResponseRegister.builder().token(token).build());
    }

    @PutMapping("/{hotelId}")
    public CommonResponse<Void> modifyHotel(@PathVariable String hotelId,
                                            @RequestBody HotelDto.RequestRegisterHotel updateHotel) {
        hotelFacade.updateHotel(hotelId, updateHotel);
        return CommonResponse.success(null);
    }

    @DeleteMapping("/{hotelId}")
    public CommonResponse<Void> deleteHotel(@PathVariable String hotelId) {
        hotelFacade.deleteHotel(hotelId);
        return CommonResponse.success(null);
    }
}
