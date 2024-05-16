package com.subprj.reservation.domain;

public interface ReservationRedissonLock {
    boolean lock(String key, Process process);
}
