package com.petrovnikita.spring.coffeeShop.service;

import com.petrovnikita.spring.coffeeShop.dao.ClientDao;
import com.petrovnikita.spring.coffeeShop.dao.CoffeeDao;
import com.petrovnikita.spring.coffeeShop.dao.TaskDao;
import com.petrovnikita.spring.coffeeShop.entity.Client;
import com.petrovnikita.spring.coffeeShop.entity.Coffee;
import com.petrovnikita.spring.coffeeShop.entity.Task;
import com.petrovnikita.spring.coffeeShop.form.CoffeeForm;
import com.petrovnikita.spring.coffeeShop.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AllServiceImpl implements AllService {

    @Autowired
    private CoffeeDao coffeeDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private ClientDao clientDao;


    // CoffeeDao ------------------------------------------------------------------------------
    @Override
    @Transactional
    public List<CoffeeInfo> getAllCoffee() {
        return coffeeDao.getAllCoffee();
    }

    @Override
    @Transactional
    public void saveCoffee(CoffeeForm coffee) {
        coffeeDao.saveCoffee(coffee);
    }

    @Override
    @Transactional
    public Coffee getCoffee(int id) {
        return coffeeDao.getCoffee(id);
    }

    @Override
    @Transactional
    public void deleteCoffee(int id) {
        coffeeDao.deleteCoffee(id);
    }

    // TaskDao ------------------------------------------------------------------------------

    @Override
    @Transactional
    public List<TaskInfo> getAllTask() {
        return taskDao.getAllTask();
    }

    @Override
    @Transactional
    public void saveTask(CartInfo cart) {
        taskDao.saveTask(cart);
    }

    @Override
    @Transactional
    public Task getTask(int id) {
        return taskDao.getTask(id);
    }

    @Override
    @Transactional
    public void deleteTask(int id) {
        taskDao.deleteTask(id);
    }

    @Override
    @Transactional
    public List<TaskInfo> getAllTaskByClient(int id) {
        return taskDao.getAllTaskByClient(id);
    }

    @Override
    @Transactional
    public List<TaskDetailInfo> getListTaskDetailInfo(int id){
        return taskDao.getListTaskDetailInfo(id);
    }

    @Override
    @Transactional
    public TaskInfo getTaskInfo(int taskId){
        return taskDao.getTaskInfo(taskId);
    }

    // ClientDao ------------------------------------------------------------------------------

    @Override
    @Transactional
    public List<ClientInfo> getAllClients() {
        return clientDao.getAllClients();
    }

    @Override
    @Transactional
    public void saveClient(Client client) {
        clientDao.saveClient(client);
    }

    @Override
    @Transactional
    public Client getClient(int id) {
        return clientDao.getClient(id);
    }

    @Override
    @Transactional
    public void deleteClient(int id) {
        clientDao.deleteClient(id);
    }

    @Override
    @Transactional
    public ClientInfo getClientInfo(int id) {
        return clientDao.getClientInfo(id);
    }
}
