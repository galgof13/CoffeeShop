package com.petrovnikita.spring.coffeeShop.dao;

import com.petrovnikita.spring.coffeeShop.entity.Coffee;
import com.petrovnikita.spring.coffeeShop.form.CoffeeForm;
import com.petrovnikita.spring.coffeeShop.model.CoffeeInfo;

import java.util.List;

public interface CoffeeDao {

    List<CoffeeInfo> getAllCoffee();

    CoffeeInfo getCoffeeInfo(int id);

    void saveCoffee(CoffeeForm coffee);

    Coffee getCoffee(int id);

    void deleteCoffee(int id);
}
