package com.example.demo.services;

import com.example.demo.repositories.ITodoRepository;
import com.example.demo.schema.Todo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

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

    @Override
    public void createTodo(Todo todo) {
        todoRepository.addTodo(todo);
    }

    @Override
    public void updateTodo(Todo todo, Long id) {
        todoRepository.updateTodo(todo, id);
    }
}






