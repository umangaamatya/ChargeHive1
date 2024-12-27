/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chargehive.model;

/**
 *
 * @author amatyaumanga
 */
public class Station {
    private int id;
    private String name;
    private String location;
    private String availability;
    private float price;
    private int ports;
    private String type;
    
    public Station(int id, String name, String location, String availability, float price, int ports, String type) {
                this.id = id;
                this.name = name;
                this.location = location;
                this.availability = availability;
                this.price = price;
                this.ports = ports;
                this.type = type;
    }
    
  
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getAvailability() {
        return availability;
    }

    public float getPrice() {
        return price;
    }

    public int getPorts() {
        return ports;
    }

    public String getType() {
        return type;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPorts(int ports) {
        this.ports = ports;
    }

    public void setType(String type) {
        this.type = type;
    }
}
