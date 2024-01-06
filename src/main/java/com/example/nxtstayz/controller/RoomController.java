package com.example.nxtstayz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.nxtstayz.model.*;

import com.example.nxtstayz.service.*;

@RestController
public class RoomController {
    @Autowired
    private RoomJpaService roomServiceObject;

    @GetMapping("/hotels/rooms")
    ArrayList<Room> getRooms() {
        return roomServiceObject.getRooms();
    }

    @GetMapping("/hotels/rooms/{roomid}")
    Room getRoomById(@PathVariable("roomid") int roomId) {
        return roomServiceObject.getRoomById(roomId);
    }

    @PostMapping("/hotels/rooms")
    Room postRoom(@RequestBody Room room) {
        return roomServiceObject.postRoom(room);
    }

    @PutMapping("/hotels/rooms/{roomid}")
    Room putRoom(@PathVariable("roomid") int roomId, @RequestBody Room room) {
        return roomServiceObject.putRoom(roomId, room);
    }

    @DeleteMapping("/hotels/rooms/{roomid}")
    void deleteRoom(@PathVariable("roomid") int roomId) {
        roomServiceObject.deleteRoom(roomId);
    }

    @GetMapping("/rooms/{roomid}/hotel")
    Hotel getHotel(@PathVariable("roomid") int roomId) {
        return roomServiceObject.getHotel(roomId);
    }

}
