package com.subprj.reservation.infrastructure;

import com.subprj.reservation.domain.Reservation;
import com.subprj.reservation.domain.ReservationStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReservationStoreImpl extends ReservationStore {
    private final ReservationRepository reservationRepository;
    @Override
    public Reservation store(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
