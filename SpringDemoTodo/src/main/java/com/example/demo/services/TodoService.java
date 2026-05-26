package com.example.demo.services;
import com.example.demo.repositories.ITodoRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;
import com.example.demo.schema.Todo;
import com.example.demo.repositories.InMemoryTodoRepository;

@Service 
@AllArgsConstructor
public class TodoService implements ITodoService {

    private final ITodoRepository todoRepository;// it is violating dependency inversion principle because todo service is dependent on concrete class not interface
    @Override
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }
}