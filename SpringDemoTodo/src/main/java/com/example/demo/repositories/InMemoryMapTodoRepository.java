package com.example.demo.repositories;

import com.example.demo.schema.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class InMemoryMapTodoRepository implements ITodoRepository{
    @Override
    public List<Todo> findAll() {
        return List.of();
    }
}
