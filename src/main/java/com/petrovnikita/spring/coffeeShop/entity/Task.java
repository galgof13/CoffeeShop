package com.petrovnikita.spring.coffeeShop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "delivery_time")
    private String deliveryTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date date;


    @Column(name = "amount")
    private float amount;


    public Task() {
    }

    public Task(int id, Client client, String deliveryTime, List<Coffee> coffees, float amount) {
        this.id = id;
        this.client = client;
        this.deliveryTime = deliveryTime;
        this.amount = amount;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", client=" + client +
                ", deliveryTime='" + deliveryTime + '\'' +
                '}';
    }
}
