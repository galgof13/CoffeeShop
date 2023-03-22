package com.petrovnikita.spring.coffeeShop.model;

import com.petrovnikita.spring.coffeeShop.entity.Coffee;

public class CoffeeInfo {

    private int id;
    private String name;
    private float evaluationBySCA;
    private String description;
    private float price;

    public CoffeeInfo() {
    }

    public CoffeeInfo(int id, String name, float evaluationBySCA, String description, float price) {
        this.id = id;
        this.name = name;
        this.evaluationBySCA = evaluationBySCA;
        this.description = description;
        this.price = price;
    }

    public CoffeeInfo(Coffee coffee){
        this.id = coffee.getId();
        this.name = coffee.getName();
        this.evaluationBySCA = coffee.getEvaluationBySCA();
        this.description = coffee.getDescription();
        this.price = coffee.getPrice();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getEvaluationBySCA() {
        return evaluationBySCA;
    }

    public void setEvaluationBySCA(float evaluationBySCA) {
        this.evaluationBySCA = evaluationBySCA;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
