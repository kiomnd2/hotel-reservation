package com.subprj.reservation.application;

import com.subprj.reservation.domain.ReservationInfo;
import com.subprj.reservation.domain.ReservationService;
import com.subprj.reservation.interfaces.ReservationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationFacade {
    private final ReservationService reservationService;

    public String createReservation(ReservationDto.RequestRegister request) {
        return reservationService.register(request.toCommand());
    }

    public List<ReservationInfo> getReservationsRoom(String startDate, String endDate) {
        return reservationService.getReservationsBetweenDate(startDate, endDate);
    }
}
