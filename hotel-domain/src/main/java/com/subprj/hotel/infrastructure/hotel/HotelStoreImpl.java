package com.subprj.hotel.infrastructure.hotel;

import com.subprj.hotel.domain.hotel.Hotel;
import com.subprj.hotel.domain.hotel.HotelStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HotelStoreImpl implements HotelStore {
    private final HotelRepository hotelRepository;

    @Override
    public Hotel store(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
