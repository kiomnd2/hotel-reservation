package com.subprj.reservation.interfaces;

import com.subprj.common.resposne.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/reservations")
public class ReservationApi {

    @GetMapping
    public CommonResponse<List<ReservationDto.ResponseHistory>> getUserHistory() {
        return CommonResponse.success(List.of());
    }

    @PutMapping
    public CommonResponse<Void> createReservation() {
        return CommonResponse.success(null);
    }

    @DeleteMapping("{reservationId}")
    public CommonResponse<Void> cancelReservation(@PathVariable String reservationId) {
        return CommonResponse.success(null);
    }

}
