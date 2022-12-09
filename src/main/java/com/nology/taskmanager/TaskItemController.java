package com.nology.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TaskItemController {

    @Autowired
    TaskItemService taskItemService;

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteTaskItemById(@PathVariable long id) {
        taskItemService.deleteTaskItemById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<TaskItem> updateTaskItem(@PathVariable long id, @RequestBody TaskItem taskItem) {
        taskItemService.updateTaskItem(id, taskItem);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
