package com.example.service;

import com.example.TestHelpers;
import com.example.converter.ObjectConverter;
import com.example.dao.TodoRespository;
import com.example.dto.TodoDTO;
import com.example.model.Todo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoServiceTest {

    @Mock
    TodoRespository dao;

    @InjectMocks
    private TodoService todoService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldCall_Repository() {
        TodoDTO todoDTO = TestHelpers.createDTO("task-1", "today");
        Todo todo = Todo.builder().name(todoDTO.getName()).createdOn(todoDTO.getCreatedOn()).build();
        doReturn(todo).when(dao).save(todo);
        todoService.add(todoDTO);
        Assert.assertEquals("db-name", todo.getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_IllegalArgument() {
        TodoDTO todoDTO = TestHelpers.createDTO("", "today");
        Todo todo = Todo.builder().name(todoDTO.getName()).createdOn(todoDTO.getCreatedOn()).build();
        doReturn(todo).when(dao).save(todo);
        todoService.add(todoDTO);

    }

}
