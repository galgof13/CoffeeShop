package com.petrovnikita.spring.coffeeShop.dao;

import com.petrovnikita.spring.coffeeShop.entity.Task;
import com.petrovnikita.spring.coffeeShop.model.CartInfo;
import com.petrovnikita.spring.coffeeShop.model.TaskDetailInfo;
import com.petrovnikita.spring.coffeeShop.model.TaskInfo;

import java.util.List;

public interface TaskDao {

    public List<TaskInfo> getAllTask();

    public void saveTask(CartInfo cart);

    public Task getTask(int id);

    public void deleteTask(int id);

    public List<TaskDetailInfo> getListTaskDetailInfo(int taskId);

    public TaskInfo getTaskInfo(int taskId);

    List<TaskInfo> getAllTaskByClient(int id);
}
