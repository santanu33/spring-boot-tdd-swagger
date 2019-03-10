package com.example.converter;

import com.example.dto.TodoDTO;
import com.example.model.Todo;

public class ObjectConverter {

    public static Todo createBookDTOResponse(TodoDTO todoDTO){


        return Todo.builder().name(todoDTO.getName()).createdOn(todoDTO.getCreatedOn()).build();
    }
}
