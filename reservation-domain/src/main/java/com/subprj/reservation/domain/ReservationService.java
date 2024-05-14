package com.subprj.reservation.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationValidator reservationValidator;
    private final ReservationStore reservationStore;
    private final ReservationReader reservationReader;

    @Transactional
    public String register(ReservationCommand.CreateReservation request) {
        Reservation reservation = request.toEntity();
        reservation.valid(reservationValidator);
        return reservationStore.store(reservation).getUuid();
    }

    public List<ReservationInfo> getReservationsBetweenDate(String startDate, String endDate) {
        return reservationReader.read(startDate, endDate).stream()
                .map(Reservation::toInfo).collect(Collectors.toList());
    }
}
