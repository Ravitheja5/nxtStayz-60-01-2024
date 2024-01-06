package com.example.nxtstayz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import com.example.nxtstayz.repository.*;
import com.example.nxtstayz.model.*;

@Service
public class HotelJpaService implements HotelRepository {

    @Autowired
    private HotelJpaRepository hotelJpaObject;

    @Autowired
    private RoomJpaRepository roomJpaObject;

    public ArrayList<Hotel> getHotels() {
        List<Hotel> list = hotelJpaObject.findAll();
        ArrayList<Hotel> arrList = new ArrayList<>(list);
        return arrList;
    }

    public Hotel getHotelById(int hotelId) {
        try {
            Hotel hotel = hotelJpaObject.findById(hotelId).get();
            return hotel;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Hotel postHotel(Hotel hotel) {

        hotelJpaObject.save(hotel);
        return hotel;

    }

    public Hotel putHotel(int hotelId, Hotel hotel) {
        try {

            Hotel currentHotel = hotelJpaObject.findById(hotelId).get();
            if (hotel.getHotelName() != null) {
                currentHotel.setName(hotel.getHotelName());
            }
            if (hotel.getLocation() != null) {
                currentHotel.setLocation(hotel.getLocation());
            }
            if (hotel.getRating() != 0) {
                currentHotel.setRating(hotel.getRating());
            }

            hotelJpaObject.save(currentHotel);
            return currentHotel;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteHotel(int hotelId) {

        try {

            hotelJpaObject.deleteById(hotelId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        List<Room> roomsList = roomJpaObject.findAll();
        for (Room eachRoom : roomsList) {
            Hotel hotel = eachRoom.getHotel();
            int oldHotelID = hotel.getHotelId();
            if (oldHotelID == hotelId) {
                eachRoom.setHotel(null);
            }
        }
        roomJpaObject.saveAll(roomsList);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);

    }

    public ArrayList<Room> getRooms(int hotelId) {
        try {

            List<Room> roomsList = roomJpaObject.findAll();
            ArrayList<Room> roomsList2 = new ArrayList<>();
            for (Room eachRoom : roomsList) {
                Hotel hotel = eachRoom.getHotel();
                int oldHotelID = hotel.getHotelId();
                if (oldHotelID == hotelId) {
                    roomsList2.add(eachRoom);
                }
            }
            return roomsList2;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}