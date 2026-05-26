package com.example.demo.repositories;

import com.example.demo.schema.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Profile;

import java.util.List;


@Repository("inMemoryMapTodoRepository")
@Profile("DEV")
public class InMemoryMapTodoRepository implements ITodoRepository{
    @Override
    public List<Todo> findAll() {
        return List.of();
    }
}
