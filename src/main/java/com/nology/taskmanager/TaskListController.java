package com.nology.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TaskListController {

    @Autowired
    TaskListService taskListService;

    @GetMapping("/lists")
    public ResponseEntity<List<TaskList>> getTaskLists() {
        return ResponseEntity.status(HttpStatus.OK).body(taskListService.getAllTaskLists());
    }

    @GetMapping("/lists/{id}")
    public ResponseEntity<TaskList> getTaskList(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskListService.getSingleTaskList(id));
    }

    @PostMapping("/lists")
    public ResponseEntity<TaskList> createTaskList(@RequestBody TaskList taskList) {
        taskListService.addTaskList(taskList);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskList);
    }

    @DeleteMapping("/lists/{id}")
    public ResponseEntity<Void> deleteTaskListById(@PathVariable long id) {
        taskListService.deleteTaskListById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/lists/{id}")
    public ResponseEntity<TaskList> updateTaskList(@PathVariable long id, @RequestBody TaskList taskList) {
        taskListService.updateTaskList(id, taskList);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/lists/{id}")
    public ResponseEntity<TaskItem> createTaskItem(@PathVariable long id, @RequestBody TaskItem taskItem) {
        taskListService.addTaskItem(id, taskItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskItem);
    }
}
