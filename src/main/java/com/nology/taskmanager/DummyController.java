package com.nology.taskmanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello world!";
    }
}
