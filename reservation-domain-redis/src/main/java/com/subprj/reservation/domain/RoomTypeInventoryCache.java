package com.subprj.reservation.domain;

import com.subprj.common.utils.DateTimeUtil;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@RedisHash(value = "ROOM_INVENTORY", timeToLive = 30)
public class RoomTypeInventoryCache {

    @Id
    private final String hotelId_roomTypeId_date;
    private final Integer totalInventory;
    private final Integer totalReservation;

    @Builder
    public RoomTypeInventoryCache(String hotelId, String roomTypeId, LocalDateTime date,
                                  Integer totalInventory, Integer totalReservation) {
        this.hotelId_roomTypeId_date = hotelId + roomTypeId + DateTimeUtil.toString(date);
        this.totalInventory = totalInventory;
        this.totalReservation = totalReservation;
    }
}
