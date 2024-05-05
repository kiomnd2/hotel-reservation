package com.subprj.hotel.infrastructure.hotel;

import com.subprj.hotel.domain.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findByUuid(String uuid);
}
