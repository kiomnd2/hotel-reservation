package com.subprj.reservation.infrastructure;

import com.subprj.reservation.domain.RoomTypeInventory;
import com.subprj.reservation.domain.RoomTypeInventoryStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoomTypeInventoryStoreImpl extends RoomTypeInventoryStore {
    private final RoomTypeInventoryRepository reservationRepository;
    @Override
    public RoomTypeInventory store(RoomTypeInventory reservation) {
        return reservationRepository.save(reservation);
    }
}
