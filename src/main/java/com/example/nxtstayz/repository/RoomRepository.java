package com.example.nxtstayz.repository;

import java.util.ArrayList;
import com.example.nxtstayz.model.*;

public interface RoomRepository {
    ArrayList<Room> getRooms();

    Room getRoomById(int roomId);

    Room postRoom(Room room);

    Room putRoom(int roomId, Room room);

    void deleteRoom(int roomId);

    Hotel getHotel(int roomId);

}