package com.subprj.reservation.infrastructure;

import com.subprj.reservation.domain.RoomTypeInventoryCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeCacheInventoryRepository extends CrudRepository<RoomTypeInventoryCache, String> {
}
