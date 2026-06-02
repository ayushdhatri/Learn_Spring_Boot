package com.example.demo.controllers;

import com.example.demo.schema.Todo;
import com.example.demo.services.ITodoService;
import com.example.demo.services.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/todos")
@Controller
public class TodoController {
    @Autowired
    private final ITodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    // TODO :  add a new todos
    @PostMapping
    public void createTodo(@RequestBody Todo todo){// here ideally we should acccept DTO because two systems are different
        todoService.createTodo(todo);
        return;// ideally we should return a successfully message
    }

    // TODO : update a todo
    @PutMapping
    public void updateTodo(@RequestBody Todo todo, @PathVariable Long id){
        todoService.updateTodo(todo, id);
        return;
    }

    // TODO : delete a todo
}
