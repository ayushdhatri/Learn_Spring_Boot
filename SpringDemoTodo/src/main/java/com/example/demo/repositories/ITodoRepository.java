package com.example.demo.repositories;

import com.example.demo.schema.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITodoRepository {
    List<Todo> findAll();
}
