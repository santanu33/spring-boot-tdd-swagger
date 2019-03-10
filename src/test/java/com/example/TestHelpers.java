package com.example;

import com.example.dto.TodoDTO;

public class TestHelpers {

    public static  TodoDTO createDTO(String name, String createdOn){
        return  TodoDTO.builder().name(name).createdOn(createdOn).build();
    }
}
