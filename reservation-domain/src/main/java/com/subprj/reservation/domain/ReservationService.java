package com.subprj.reservation.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationValidator reservationValidator;
    private final ReservationStore reservationStore;

    @Transactional
    public String register(ReservationCommand.CreateReservation request) {
        Reservation reservation = request.toEntity();
        reservation.valid(reservationValidator);
        return reservationStore.store(reservation).getUuid();
    }
}
