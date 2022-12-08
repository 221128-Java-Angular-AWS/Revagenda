package com.revature.pojos;

import java.util.Objects;

public class Task {
    private Integer taskId;
    private String title;
    private String description;
    private Boolean completed;
    private Integer user_id;


    public Task() {
    }

    public Task(Integer taskId, String title, String description, Boolean completed, Integer user_id) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.user_id = user_id;
    }

    public Task(String title, String description, Boolean completed, Integer user_id) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.user_id = user_id;
    }

    public Task(String title, String description, Boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
