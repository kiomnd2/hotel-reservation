package com.subprj.reservation.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Builder
@RequiredArgsConstructor
public class RoomTypeInventoryInfo {
    private final String uuid;
    private final String hotelId;
    private final String roomTypeId;
    private final LocalDate date;
    private final Integer totalInventory;
    private final Integer totalReservation;
}
