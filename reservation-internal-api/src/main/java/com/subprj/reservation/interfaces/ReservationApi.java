package com.subprj.reservation.interfaces;

import com.subprj.common.response.CommonResponse;
import com.subprj.reservation.application.ReservationFacade;
import com.subprj.reservation.domain.RoomTypeInventoryInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/reservations")
public class ReservationApi {
    private final ReservationFacade reservationFacade;

    // 신규 예약 생성
    // 매니저만 가능
    @PutMapping("/manage")
    public CommonResponse<ReservationDto.ResponseRegister> createRoomTypeInventory(
            @RequestBody ReservationDto.RequestRegisterRoomTypeInventory request) {
        String token = reservationFacade.createRoomTypeInventory(request);
        return CommonResponse.success(ReservationDto.ResponseRegister.builder().token(token).build());
    }

    @GetMapping("{startDate}/{endDate}")
    public CommonResponse<List<ReservationDto.ResponseCreateRoomInventory>> getRoomTypeInventoryBetweenDate(
            @PathVariable String startDate, @PathVariable String endDate) {
        List<RoomTypeInventoryInfo> reservationsRoom = reservationFacade.getReservationsRoom(startDate, endDate);
        return CommonResponse.success(ReservationDto.ResponseCreateRoomInventory.byInfo(reservationsRoom));
    }

    @PutMapping
    public CommonResponse<ReservationDto.ResponseReservation> createReservation(
            @RequestBody ReservationDto.RequestReservation reservation) {
        boolean isReservation = reservationFacade.createReservation(reservation);
        return CommonResponse.success(ReservationDto.ResponseReservation.builder()
                        .isReservation(isReservation)
                .build());
    }

    @GetMapping
    public CommonResponse<List<ReservationDto.ResponseHistory>> getUserHistory() {
        return CommonResponse.success(List.of());
    }

    @DeleteMapping("{reservationId}")
    public CommonResponse<Void> cancelReservation(@PathVariable String reservationId) {
        return CommonResponse.success(null);
    }

}
