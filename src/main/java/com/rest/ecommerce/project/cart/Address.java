package com.rest.ecommerce.project.cart;

import javax.persistence.*;

@Entity
public class Address {
    @GeneratedValue
    @javax.persistence.Id
    private Integer id;
    private String city;
    private Integer block;
    private String street;
    private String building;
    private String floor;
    private String extraInfo;

    @JoinColumn(name = "user")
    @ManyToOne(fetch = FetchType.EAGER)
    private JwtUser user;

    public Address() {
    }

    public Address(Integer id, String city, Integer block, String street, String building, String floor, String extraInfo) {
        this.id = id;
        this.city = city;
        this.block = block;
        this.street = street;
        this.building = building;
        this.floor = floor;
        this.extraInfo = extraInfo;
    }

    public JwtUser getUser() {
        return user;
    }

    public void setUser(JwtUser user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", block=" + block +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", floor='" + floor + '\'' +
                ", extraInfo='" + extraInfo + '\'' +
                '}';
    }
}
