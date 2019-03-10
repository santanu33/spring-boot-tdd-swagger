package com.example.controller;


import com.example.dto.TodoDTO;
import com.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {


    @Autowired
    TodoService todoService;


    @PostMapping("/todo")
    public TodoDTO addTodo(@RequestBody TodoDTO  todoDTO){
        todoService.add(todoDTO);
        return  todoDTO;
    }

}

