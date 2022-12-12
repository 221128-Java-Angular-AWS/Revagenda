package com.revature.service;

import com.revature.persistence.TaskDao;
import com.revature.pojos.Task;

public class TaskService {
    private TaskDao dao;


    public TaskService(TaskDao dao) {
        this.dao = dao;
    }

    public void createNewTask(Task task) {
        dao.create(task);
    }

    public Task getTask(Integer id) {
        return dao.read(id);
    }

    public void updateTask(Task task) {
        dao.update(task);
    }

    public void deleteTask(Integer id) {
        dao.delete(id);
    }
}
