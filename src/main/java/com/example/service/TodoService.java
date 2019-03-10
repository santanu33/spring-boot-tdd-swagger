package com.example.service;

import com.example.converter.ObjectConverter;
import com.example.dao.TodoRespository;
import com.example.dto.TodoDTO;
import com.example.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional

public class TodoService {


    TodoRespository todoRespository;

    @Autowired
    public TodoService(TodoRespository todoRespository) {
        this.todoRespository = todoRespository;
    }

    public Todo add(TodoDTO todoDTO) throws  IllegalArgumentException {

        Todo todo = null;
        todo = ObjectConverter.createBookDTOResponse(todoDTO);

        todo = todoRespository.save(todo);
        if(todo.getName().length() == 0 ){
            throw new IllegalArgumentException("name can't be empty");
        }
        todo.setName("db-name");
        System.out.println(todoDTO);

        return todo;
    }
}
