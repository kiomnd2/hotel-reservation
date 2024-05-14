package com.subprj.interfaces.hotel;

import com.subprj.application.hotel.HotelFacade;
import com.subprj.common.response.CommonResponse;
import com.subprj.hotel.domain.hotel.HotelInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/hotels")
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

    // Room
    @GetMapping("{hotelId}/rooms/{roomId}")
    public CommonResponse<RoomDto.ResponseRoom> getHotelRoom(@PathVariable String hotelId
            , @PathVariable String roomId) {
        return CommonResponse.success(RoomDto.ResponseRoom.builder().build());
    }

    @PostMapping("{hotelId}/rooms")
    public CommonResponse<RoomDto.ResponseToken> addHotelRoom(@PathVariable String hotelId
            , @RequestBody RoomDto.RequestRoom requestRoom) {
        String token = hotelFacade.addHotelRoom(hotelId, requestRoom);
        return CommonResponse.success(RoomDto.ResponseToken.builder().roomToken(token).build());
    }

    @PutMapping("{hotelId}/rooms/{roomId}")
    public CommonResponse<Void> modifyHotelRoom(@PathVariable String hotelId
            , @PathVariable String roomId
            , @RequestBody RoomDto.RequestRoom requestRoom)  {
        hotelFacade.modifyHotelRoom(hotelId, roomId, requestRoom);
        return CommonResponse.success(null);
    }

    @DeleteMapping("{hotelId}/rooms/{roomId}")
    public CommonResponse<Void> deleteHotelRoom(@PathVariable String hotelId
            , @PathVariable String roomId) {
        hotelFacade.deleteHotelRoom(hotelId, roomId);
        return CommonResponse.success(null);
    }

}
