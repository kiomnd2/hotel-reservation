package com.subprj.hotel.domain.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class HotelService {
    private final HotelStore hotelStore;
    private final HotelReader hotelReader;

    public HotelInfo getHotel(String uuid) {
        return hotelReader.read(uuid).toInfo();
    }

    public HotelInfo saveHotel(HotelCommand.PutHotel command) {
        return hotelStore.store(command.toEntity()).toInfo();
    }

    @Transactional
    public void modifyHotel(String hotelId, HotelCommand.PutHotel command) {
        Hotel read = hotelReader.read(hotelId);
        read.put(command);
    }

    @Transactional
    public void deleteHotel(String hotelId) {
        Hotel read = hotelReader.read(hotelId);
        read.deleteHotel();
    }

}
