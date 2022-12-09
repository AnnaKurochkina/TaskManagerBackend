package com.nology.taskmanager;

public class TaskItemNotFoundException extends RuntimeException {
    public TaskItemNotFoundException() {
        super("Task item has not been found");
    }
}
