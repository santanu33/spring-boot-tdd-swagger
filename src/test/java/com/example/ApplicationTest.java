package com.example;

import com.example.controller.TodoController;
import com.example.dao.TodoRespository;
import com.example.service.TodoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest


public class ApplicationTest {

    @Autowired
    private TodoController todoController;

    @Test
    public void contextLoads() {

        System.out.println(todoController);
        Assert.assertNotEquals(null,todoController);

    }

}
