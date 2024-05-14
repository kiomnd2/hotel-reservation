package com.subprj.reservation.interfaces;

import com.subprj.common.response.CommonResponse;
import com.subprj.reservation.application.ReservationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/reservations")
public class ReservationApi {
    private final ReservationFacade reservationFacade;

    @PutMapping
    public CommonResponse<ReservationDto.ResponseRegister> createReservation(
            @RequestBody ReservationDto.RequestRegister request) {
        String token = reservationFacade.createReservation(request);
        return CommonResponse.success(ReservationDto.ResponseRegister.builder().token(token).build());
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
