package com.subprj.reservation.infrastructure;

import com.subprj.reservation.domain.RoomTypeInventory;
import com.subprj.reservation.domain.RoomTypeInventoryStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoomTypeInventoryStoreImpl extends RoomTypeInventoryStore {
    private final RoomTypeInventoryRepository reservationRepository;
    private final RoomTypeCacheInventoryRepository cacheStore;
    @Override
    public RoomTypeInventory store(RoomTypeInventory reservation) {
        cacheStore.save(reservation.toCache());
        return reservationRepository.save(reservation);
    }
}
