package com.petrovnikita.spring.coffeeShop.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "coffee")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "evaluation_by_SCA")
    private float evaluationBySCA;

    @Column(name = "description")
    private String description;

    @Column(name = "price_per_200g")
    private float price;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Date createDate;


    public Coffee() {
    }

    public Coffee(String name, float evaluationBySCA, String description, int price) {
        this.name = name;
        this.evaluationBySCA = evaluationBySCA;
        this.description = description;
        this.price = price;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", evaluationBySCA=" + evaluationBySCA +
                ", description='" + description + '\'' +
                '}';
    }
}
