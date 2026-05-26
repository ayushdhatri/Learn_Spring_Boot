package com.example.demo.services;

import com.example.demo.repositories.ITodoRepository;
import com.example.demo.schema.Todo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ITodoService {

    private final ITodoRepository todoRepository;

    public TodoService(
            @Qualifier("inMemoryMapTodoRepository")
            ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
}