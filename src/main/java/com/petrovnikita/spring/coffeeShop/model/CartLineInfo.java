package com.petrovnikita.spring.coffeeShop.model;

public class CartLineInfo {

    private CoffeeInfo coffeeInfo;
    private int quantity;

    public CartLineInfo() {
        this.quantity = 0;
    }

    public CoffeeInfo getCoffeeInfo() {
        return coffeeInfo;
    }

    public void setCoffeeInfo(CoffeeInfo coffeeInfo) {
        this.coffeeInfo = coffeeInfo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount(){
        return coffeeInfo.getPrice() * quantity;
    }
}
