package com.example.demo.repositories;

import com.example.demo.schema.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Profile;

import java.util.List;


@Repository("inMemoryMapTodoRepository")
//@Profile("DEV")
public class InMemoryMapTodoRepository implements ITodoRepository{
    @Override
    public List<Todo> findAll() {
        return List.of();
    }

    @Override
    public void addTodo(Todo todo) {

    }

    @Override
    public void updateTodo(Todo todo, Long id) {
        return;// as this class is dummy not used in production
    }

}
