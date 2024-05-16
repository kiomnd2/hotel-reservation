package com.subprj.reservation.infrastructure;

import com.subprj.reservation.domain.ReservationReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class ReservationReaderImpl implements ReservationReader {
    private final ReservationRepository reservationRepository;
    @Override
    public boolean checkReservation(String reservationId) {
        return reservationRepository.existsByReservationId(reservationId);
    }
}
