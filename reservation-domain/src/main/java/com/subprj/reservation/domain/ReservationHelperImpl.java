package com.subprj.reservation.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReservationHelperImpl implements ReservationHelper {
    @Override
    public boolean reservation(String reservationId, String hotelId, String roomTypeId) {
        // 해당 일자에 방이 있는지 확인

        // if 계산 해서 하나라도 없으면 false
        // 있으면 갯수 늘리고 true
        // 동시성 체크해야함

        return false;
    }
}
