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
}
