package com.nology.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskItemService {

    @Autowired
    private TaskItemRepository taskItemRepository;

    @Transactional
    public void deleteTaskItemById(long id) {
        if (!taskItemRepository.existsById(id)) {
            throw new TaskItemNotFoundException();
        }
        taskItemRepository.deleteTaskItemById(id);
    }

    public void updateTaskItem(long id, TaskItem taskItem) {
        var result = taskItemRepository.findById(id);

        if (result.isEmpty()) {
            throw new TaskItemNotFoundException();
        }

        var existing = result.get();
        existing.setName(taskItem.getName());
        taskItemRepository.save(existing);
    }
}
