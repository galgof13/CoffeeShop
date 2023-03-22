package com.petrovnikita.spring.coffeeShop.entity;

import javax.persistence.*;

@Entity
@Table(name = "task_detail")
public class TaskDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private float amount;

    @Column(name = "price")
    private float price;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Task taskId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coffee_id")
    private Coffee coffeeId;


    public TaskDetail() {
    }

    public TaskDetail(int id, float amount, float price, int quantity, Task taskId, Coffee coffeeId) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.quantity = quantity;
        this.taskId = taskId;
        this.coffeeId = coffeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Task getTaskId() {
        return taskId;
    }

    public void setTaskId(Task taskId) {
        this.taskId = taskId;
    }

    public Coffee getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(Coffee coffeeId) {
        this.coffeeId = coffeeId;
    }
}
