package com.subprj.reservation.domain;

import com.subprj.common.utils.DateTimeUtil;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDate;

@Getter
@RedisHash(value = "ROOM_INVENTORY", timeToLive = 30)
public class RoomTypeInventoryCache {

    @Id
    private String id ;
    private String hotelId;
    private String roomTypeId;
    private LocalDate reserveDate;
    private Integer totalInventory;
    private Integer totalReservation;

    @Builder
    public RoomTypeInventoryCache(String hotelId, String roomTypeId, LocalDate date,
                                  Integer totalInventory, Integer totalReservation) {
        this.id = hotelId + roomTypeId + DateTimeUtil.toString(date);
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
        this.reserveDate = date;
        this.totalInventory = totalInventory;
        this.totalReservation = totalReservation;
    }



    public boolean checkRoomInventory(int numberOfRoomReserve) {
        // 예약의 10퍼센트 초과까지 받음
        if (this.totalReservation + numberOfRoomReserve <= totalInventory * 1.1) {
            return true;
        }
        return false;
    }

    public RoomTypeInventoryCache reservation(int numberOfRoomReserve) {
        this.totalReservation = this.totalReservation + numberOfRoomReserve;
        return this;
    }
}
