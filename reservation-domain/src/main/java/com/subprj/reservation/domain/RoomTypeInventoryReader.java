package com.subprj.reservation.domain;

import java.util.List;

public interface RoomTypeInventoryReader {
    List<RoomTypeInventory> read(String startDate, String endDate);
    List<RoomTypeInventory> read(String hotelId, String roomId, String startDate, String endDate);
}
