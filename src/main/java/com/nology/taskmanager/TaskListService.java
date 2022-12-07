package com.nology.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListService {

    @Autowired
    private TaskListRepository taskListRepository;

    public List<TaskList> getAllTaskLists() {
        return taskListRepository.findAll();
    }

    public TaskList getSingleTaskList(Long id) {
        return taskListRepository.getTaskListWithItems(id);
    }

    public void addTaskList(TaskList taskList) {
        taskListRepository.save(taskList);
    }
}
