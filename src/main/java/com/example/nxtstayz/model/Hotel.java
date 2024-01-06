package com.example.nxtstayz.model;

import javax.persistence.*;
//import com.example.nxtstayz.model.*;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int hotelId;

    @Column(name = "name")
    private String hotelName;

    @Column(name = "location")
    private String location;

    @Column(name = "rating")
    private int rating;

    public Hotel() {

    }

    public Hotel(String hotelName, String location, int rating) {
        this.hotelName = hotelName;
        this.location = location;
        this.rating = rating;
    }

    public int getHotelId() {
        return this.hotelId;
    }

    public void setId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return this.hotelName;
    }

    public void setName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
