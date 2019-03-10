package com.example.dao;

import com.example.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRespository extends CrudRepository<Todo, Long> {



}
