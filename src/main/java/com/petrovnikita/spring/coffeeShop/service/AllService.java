package com.petrovnikita.spring.coffeeShop.service;

import com.petrovnikita.spring.coffeeShop.entity.Client;
import com.petrovnikita.spring.coffeeShop.entity.Coffee;
import com.petrovnikita.spring.coffeeShop.entity.Task;
import com.petrovnikita.spring.coffeeShop.form.CoffeeForm;
import com.petrovnikita.spring.coffeeShop.model.*;

import java.util.List;

public interface AllService {

    // CoffeeDao ------------------------------------------------------------------------------
    List<CoffeeInfo> getAllCoffee();

    void saveCoffee(CoffeeForm coffee);

    Coffee getCoffee(int id);

    void deleteCoffee(int id);

    // TaskDao ------------------------------------------------------------------------------

    List<TaskInfo> getAllTask();

    void saveTask(CartInfo cart);

    Task getTask(int id);

    void deleteTask(int id);

    List<TaskDetailInfo> getListTaskDetailInfo(int id);

    TaskInfo getTaskInfo(int taskId);

    List<TaskInfo> getAllTaskByClient(int id);

    // ClientDao ------------------------------------------------------------------------------

    List<ClientInfo> getAllClients();

    void saveClient(Client client);

    Client getClient(int id);

    void deleteClient(int id);

    ClientInfo getClientInfo(int id);
}
