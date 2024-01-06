package com.example.nxtstayz.model;

import javax.persistence.*;
//import com.example.nxtstayz.model.*;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "room")

public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "id")
  private int roomId;

  @Column(name = "roomnumber")
  private String roomName;

  @Column(name = "type")
  private String type;

  @Column(name = "price")
  private double price;

  @ManyToOne
  @JoinColumn(name = "hotelid")
  private Hotel hotel;

  public Room() {

  }

  public Room(String roomName, String type, double price, Hotel hotel) {
    this.roomName = roomName;
    this.type = type;
    this.price = price;
    this.hotel = hotel;
  }

  public int getRoomId() {
    return this.roomId;
  }

  public void setId(int roomId) {
    this.roomId = roomId;
  }

  public String getRoomNumber() {
    return this.roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public String getRoomType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Hotel getHotel() {
    return this.hotel;

  }

  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }
}