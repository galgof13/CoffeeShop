package com.petrovnikita.spring.coffeeShop.model;

public class TaskDetailInfo {

    private  int id;

    private int coffeeId;

    private String coffeeName;

    private float coffeePrice;

    private int quantity;

    private float amount;



    public TaskDetailInfo() {
    }

    public TaskDetailInfo(int id, int coffeeId, String coffeeName, float coffeePrice, int quantity, float amount) {
        this.id = id;
        this.coffeeId = coffeeId;
        this.coffeeName = coffeeName;
        this.coffeePrice = coffeePrice;
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public float getCoffeePrice() {
        return coffeePrice;
    }

    public void setCoffeePrice(float coffeePrice) {
        this.coffeePrice = coffeePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
