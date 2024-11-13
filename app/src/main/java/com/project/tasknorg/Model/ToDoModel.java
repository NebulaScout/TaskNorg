package com.project.tasknorg.Model;

public class ToDoModel extends TaskId {

    private String task, due;
    private int status;

    public int getStatus() {
        return status;
    }

    public String getDue() {
        return due;
    }

    public String getTask() {
        return task;
    }
}
