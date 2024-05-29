package com.subprj.reservation.application;

import com.subprj.reservation.domain.ReservationService;
import com.subprj.reservation.domain.RoomTypeInventoryInfo;
import com.subprj.reservation.interfaces.ReservationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationFacade {
    private final ReservationService reservationService;

    public String createRoomTypeInventory(ReservationDto.RequestRegisterRoomTypeInventory request) {
        return reservationService.registerRoomTypeInventory(request.toCommand());
    }

    public List<RoomTypeInventoryInfo> getReservationsRoom(String startDate, String endDate) {
        return reservationService.getRoomTypeBetweenDate(startDate, endDate);
    }

    public boolean createReservation(ReservationDto.RequestReservation reservation) {
        return reservationService.reservation(reservation.toCommand());
    }
}
