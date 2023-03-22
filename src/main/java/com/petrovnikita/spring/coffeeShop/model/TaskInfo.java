package com.petrovnikita.spring.coffeeShop.model;

import java.util.Date;
import java.util.List;

public class TaskInfo {

    private int id;
    private Date createDate;
    private float amount;
    private String deliveryTime;


    private String address;
    private String firstName;
    private String secondName;
    private String phoneNumber;

    //private List<TaskDetailInfo> detailInfoList;


    public TaskInfo() {
    }

    public TaskInfo(int id, Date createDate, float amount, String deliveryTime, String address, String firstName, String secondName, String phoneNumber) {
        this.id = id;
        this.createDate = createDate;
        this.amount = amount;
        this.deliveryTime = deliveryTime;

        this.address = address;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //public List<TaskDetailInfo> getDetailInfoList() {
    //    return detailInfoList;
    //}

    //public void setDetailInfoList(List<TaskDetailInfo> detailInfoList) {
    //    this.detailInfoList = detailInfoList;
    //}

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
