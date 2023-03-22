package com.petrovnikita.spring.coffeeShop.model;

import com.petrovnikita.spring.coffeeShop.entity.Client;

public class ClientInfo {

    private int id;

    private String firstName;

    private String secondName;

    private String address;

    private String phoneNumber;

    private String deliveryTime;

    public ClientInfo() {
    }

    public ClientInfo(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.secondName = client.getSecondName();
        this.address = client.getAddress();
        this.phoneNumber = client.getPhoneNumber();
    }

    public ClientInfo(int id, String firstName, String secondName, String address, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
