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
public class RoomJpaService implements RoomRepository {
    @Autowired
    private RoomJpaRepository roomJpaObject;

    @Autowired
    private HotelJpaRepository hotelJpaObject;

    public ArrayList<Room> getRooms() {
        List<Room> list = roomJpaObject.findAll();
        ArrayList<Room> arrList = new ArrayList<>(list);
        return arrList;
    }

    public Room getRoomById(int roomId) {
        try {
            return roomJpaObject.findById(roomId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Room postRoom(Room room) {
        int hotelId = room.getHotel().getHotelId();
        Hotel hotel = hotelJpaObject.findById(hotelId).get();
        room.setHotel(hotel);
       return roomJpaObject.save(room);
         
    }

    public Room putRoom(int roomId, Room room) {
        try {

            Room currentRoom = roomJpaObject.findById(roomId).get();

            if (room.getRoomNumber() != null) {
                currentRoom.setRoomName(room.getRoomNumber());
            }
            if (room.getRoomType() != null) {
                currentRoom.setType(room.getRoomType());
            }
            if (room.getPrice() != 0) {
                currentRoom.setPrice(room.getPrice());
            }
            if (room.getHotel() != null) {
                int hotelId = room.getHotel().getHotelId();
                Hotel hotel = hotelJpaObject.findById(hotelId).get();
                currentRoom.setHotel(hotel);
                roomJpaObject.save(currentRoom);
            }
            return currentRoom;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteRoom(int roomId) {
        try {
            roomJpaObject.deleteById(roomId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    public Hotel getHotel(int roomId) {
        try {

            Room room = roomJpaObject.findById(roomId).get();
            return room.getHotel();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
