package com.example.demo.services;

import com.example.demo.schema.Todo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ITodoService {
    List<Todo> getAllTodos();
    void createTodo(Todo todo);
    void updateTodo(Todo todo, Long id);
}
