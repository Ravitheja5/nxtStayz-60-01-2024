package com.example.nxtstayz.repository;

import java.util.ArrayList;
import com.example.nxtstayz.model.*;
import java.util.*;

public interface HotelRepository {
    ArrayList<Hotel> getHotels();

    Hotel getHotelById(int hotelId);

    Hotel postHotel(Hotel hotel);

    Hotel putHotel(int hotelId, Hotel hotel);

    void deleteHotel(int hotelId);

    public ArrayList<Room> getRooms(int hotelId);
}
