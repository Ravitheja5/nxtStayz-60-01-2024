package com.example.nxtstayz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.nxtstayz.model.*;

import com.example.nxtstayz.service.*;

@RestController
public class HotelController {
    @Autowired
    private HotelJpaService hotelServiceObject;

    @GetMapping("/hotels")
    ArrayList<Hotel> getHotels() {
        return hotelServiceObject.getHotels();
    }

    @GetMapping("/hotels/{hotelid}")
    Hotel getHotelById(@PathVariable("hotelid") int hotelId) {
        return hotelServiceObject.getHotelById(hotelId);
    }

    @PostMapping("/hotels")
    Hotel postHotel(@RequestBody Hotel hotel) {
        return hotelServiceObject.postHotel(hotel);
    }

    @PutMapping("/hotels/{hotelid}")
    Hotel putHotel(@PathVariable("hotelid") int hotelId, @RequestBody Hotel hotel) {
        return hotelServiceObject.putHotel(hotelId, hotel);
    }

    @DeleteMapping("/hotels/{hotelid}")
    void deleteHotel(@PathVariable("hotelid") int hotelId) {
        hotelServiceObject.deleteHotel(hotelId);
    }

    @GetMapping("/hotels/{hotelid}/rooms")
    public ArrayList<Room> getRooms(@PathVariable("hotelid") int hotelId) {
        return hotelServiceObject.getRooms(hotelId);
    }
}