package com.subprj.hotel.infrastructure.hotel;

import com.subprj.hotel.common.response.exception.NotFoundHotelException;
import com.subprj.hotel.domain.hotel.Hotel;
import com.subprj.hotel.domain.hotel.HotelReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HotelReaderImpl implements HotelReader {
    private final HotelRepository hotelRepository;

    @Override
    public Hotel read(String uuid) {
        return hotelRepository.findByUuid(uuid).orElseThrow(NotFoundHotelException::new);
    }
}
