package com.subprj.reservation.infrastructure;

import com.subprj.reservation.domain.Process;
import com.subprj.reservation.domain.ReservationRedissonLock;
import lombok.RequiredArgsConstructor;
import org.redisson.RedissonLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component
public class RedissonLockImpl implements ReservationRedissonLock {
    private final RedissonClient redissonClient;

    @Override
    public boolean lock(String key, Process process) {
        String lockName = key + ":lock";
        RLock lock = redissonClient.getLock(lockName);
        try {
            if (!lock.tryLock(1, 3, TimeUnit.SECONDS)) {
                return false;
            }
            return process.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lock != null && lock.isLocked()) {
                lock.unlock();
            }
        }
        return false;
    }
}
