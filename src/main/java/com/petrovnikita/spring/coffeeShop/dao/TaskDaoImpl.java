package com.petrovnikita.spring.coffeeShop.dao;

import com.petrovnikita.spring.coffeeShop.entity.Client;
import com.petrovnikita.spring.coffeeShop.entity.Coffee;
import com.petrovnikita.spring.coffeeShop.entity.Task;
import com.petrovnikita.spring.coffeeShop.entity.TaskDetail;
import com.petrovnikita.spring.coffeeShop.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CoffeeDao coffeeDao;

    @Autowired
    private ClientDao clientDao;


    @Override
    public List<TaskInfo> getAllTask() {
        Session session = sessionFactory.getCurrentSession();

        String sql = "Select new com.petrovnikita.spring.coffeeShop.model.TaskInfo" +
                "(t.id, t.date, t.amount, t.deliveryTime, t.client.address, t.client.firstName," +
                " t.client.secondName, t.client.phoneNumber) from Task t";

        List<TaskInfo> allTask = session.createQuery(sql, TaskInfo.class)
                .getResultList();

        return allTask;
    }

    @Override
    public List<TaskInfo> getAllTaskByClient(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<TaskInfo> query = session.createQuery("Select new com.petrovnikita.spring.coffeeShop.model.TaskInfo" +
                "(t.id, t.date, t.amount, t.deliveryTime, t.client.address, t.client.firstName," +
                " t.client.secondName, t.client.phoneNumber) from Task t where t.client.id =: id");
        query.setParameter("id", id);

        List<TaskInfo> allTask = query.getResultList();

        return allTask;
    }

    @Override
    public void saveTask(CartInfo cart) {
        Session session = sessionFactory.getCurrentSession();
        ClientInfo clientInfo = cart.getClientInfo();
        String phone = clientInfo.getPhoneNumber();
        Client client = clientDao.getClientForPhone(phone);
        client.setFirstName(clientInfo.getFirstName());
        client.setSecondName(clientInfo.getSecondName());
        client.setAddress(clientInfo.getAddress());
        client.setPhoneNumber(clientInfo.getPhoneNumber());
        Task task = new Task();
        task.setClient(client);
        task.setDeliveryTime(clientInfo.getDeliveryTime());
        task.setAmount(cart.getAmountTotal());
        task.setDate(new Date());
        List<CartLineInfo> coffees = cart.getCartLines();
        for(CartLineInfo line : coffees){
            TaskDetail taskDetail = new TaskDetail();
            Coffee coffee = coffeeDao.getCoffee(line.getCoffeeInfo().getId());

            taskDetail.setTaskId(task);
            taskDetail.setCoffeeId(coffee);
            taskDetail.setPrice(coffee.getPrice());
            taskDetail.setQuantity(line.getQuantity());
            taskDetail.setAmount(line.getAmount());

            session.saveOrUpdate(taskDetail);
        }


    }

    @Override
    public Task getTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        Task task = session.get(Task.class, id);
        return task;
    }

    @Override
    public void deleteTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Coffee> query = session.createQuery("delete from Task" +
                " where id =:TaskId");
        query.setParameter("TaskId", id);
        query.executeUpdate();
    }

    @Override
    public List<TaskDetailInfo> getListTaskDetailInfo(int taskId){
        Session session = sessionFactory.getCurrentSession();
        String sql = "Select new com.petrovnikita.spring.coffeeShop.model.TaskDetailInfo" +
                "(td.id, td.coffeeId.id, td.coffeeId.name, td.price, td.quantity, td.amount) from TaskDetail td " +
                "where td.taskId.id = :taskId";

        Query<TaskDetailInfo> query = session.createQuery(sql, TaskDetailInfo.class);
        query.setParameter("taskId", taskId);
        return query.getResultList();
    }

    @Override
    public TaskInfo getTaskInfo(int taskId){
        Task task = this.getTask(taskId);
        if(task == null){
            return null;
        }
        TaskInfo taskInfo = new TaskInfo(task.getId(), task.getDate(), task.getAmount(), task.getDeliveryTime(),
                task.getClient().getAddress(), task.getClient().getFirstName(), task.getClient().getSecondName(),
                task.getClient().getPhoneNumber());
        return taskInfo;
    }
}
