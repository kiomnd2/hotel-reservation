package com.subprj.reservation.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@Getter
@Builder
@RequiredArgsConstructor
public class ReservationInfo {
    private final String uuid;
    private final String hotelId;
    private final String roomTypeId;
    private final LocalDateTime date;
    private final Integer totalInventory;
    private final Integer totalReservation;
}
