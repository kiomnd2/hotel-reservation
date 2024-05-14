package com.subprj.reservation.infrastructure;

import com.subprj.reservation.domain.Reservation;
import com.subprj.reservation.domain.ReservationReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ReservationReaderImpl implements ReservationReader {
    private final ReservationRepository reservationRepository;
    @Override
    public List<Reservation> read(String startDate, String endDate) {
        return reservationRepository.findAllByDateBetween(
                LocalDateTime.parse(startDate, DateTimeFormatter.ofPattern("yyyyMMdd")),
                LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMdd"))
        );
    }
}
