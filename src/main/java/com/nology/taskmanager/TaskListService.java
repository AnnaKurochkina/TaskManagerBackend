package com.nology.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void deleteTaskListById(long id) {
        if (!taskListRepository.existsById(id)) {
            throw new TaskListNotFoundException();
        }
        taskListRepository.deleteTaskListById(id);
    }

    public void updateTaskList(long id, TaskList taskList) {
        var result = taskListRepository.findById(id);

        if (result.isEmpty()) {
            throw new TaskListNotFoundException();
        }

        var existing = result.get();
        existing.setName(taskList.getName());
        taskListRepository.save(existing);
    }
}
