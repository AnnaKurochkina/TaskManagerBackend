package com.nology.taskmanager;

public class TaskListNotFoundException extends RuntimeException {
    public TaskListNotFoundException() {
        super("Task list has not been found");
    }
}