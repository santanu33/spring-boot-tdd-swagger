package com.example.controller;


import com.example.TestHelpers;
import com.example.dto.TodoDTO;
import com.example.service.TodoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @MockBean
    TodoService todoService;

    @Test
    public void shouldReturnTodoDTOResponseEntity() {
        String url = "http://localhost:" + port + "/todo";
        TodoDTO todoDTO = TestHelpers.createDTO("task-1", "today");
        ResponseEntity<TodoDTO> responseEntity = this.restTemplate.postForEntity(url, todoDTO, TodoDTO.class);
        Assert.assertEquals(TodoDTO.class, responseEntity.getBody().getClass());
        Assert.assertEquals(todoDTO.getName(), responseEntity.getBody().getName());
    }

    @Test
    public void shouldCallService() {
        String url = "http://localhost:" + port + "/todo";
        TodoDTO todoDTO = TestHelpers.createDTO("task-1", "today");
        System.out.println(todoDTO);
        ResponseEntity<TodoDTO> responseEntity = restTemplate.postForEntity(url, todoDTO, TodoDTO.class);
        verify(todoService, times(1)).add(todoDTO);
    }
}
