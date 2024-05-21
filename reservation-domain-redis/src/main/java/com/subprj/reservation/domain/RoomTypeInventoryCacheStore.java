package com.subprj.reservation.domain;

import com.subprj.reservation.infrastructure.RoomTypeCacheInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoomTypeInventoryCacheStore {
    private final RoomTypeCacheInventoryRepository inventoryRepository;
    public void store(RoomTypeInventoryCache roomTypeInventoryCache) {
        inventoryRepository.save(roomTypeInventoryCache);
    }
}
