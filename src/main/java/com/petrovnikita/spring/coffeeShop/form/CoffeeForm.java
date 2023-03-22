package com.petrovnikita.spring.coffeeShop.form;

import com.petrovnikita.spring.coffeeShop.entity.Coffee;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CoffeeForm {

    private int id;
    @NotEmpty(message = "the field cannot be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;
    private float evaluationBySCA;
    private String description;
    @Min(value = 1, message = "the price cannot be lower than 0")
    private float price;
    private boolean newCoffee = false;

    public CoffeeForm() {
        this.newCoffee = true;
    }

    public CoffeeForm(Coffee coffee){
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

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isNewCoffee() {
        return newCoffee;
    }

    public void setNewCoffee(boolean newCoffee) {
        this.newCoffee = newCoffee;
    }
}
