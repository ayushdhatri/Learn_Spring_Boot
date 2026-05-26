package com.example.demo.repositories;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Profile;


import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import com.example.demo.schema.Todo;

@Repository("inMemoryTodoRepository")
@AllArgsConstructor
//@Profile("PROD")
public class InMemoryTodoRepository implements  ITodoRepository {

    private List<Todo> todos = new ArrayList<>();

    public InMemoryTodoRepository() {
        todos.add(new Todo(
                1L,
                "Learn Spring Boot",
                "Complete Spring Boot basics tutorial",
                false,
                LocalDateTime.now().minusDays(5),
                LocalDateTime.now().minusDays(5)
        ));

        todos.add(new Todo(
                2L,
                "Practice DSA",
                "Solve 3 LeetCode problems",
                true,
                LocalDateTime.now().minusDays(3),
                LocalDateTime.now().minusDays(1)
        ));

        todos.add(new Todo(
                3L,
                "Build Todo API",
                "Create CRUD endpoints for Todo application",
                false,
                LocalDateTime.now().minusHours(10),
                LocalDateTime.now().minusHours(2)
        ));

        todos.add(new Todo(
                4L,
                "Read System Design",
                "Study caching and load balancing concepts",
                false,
                LocalDateTime.now().minusDays(2),
                LocalDateTime.now().minusDays(2)
        ));

        todos.add(new Todo(
                5L,
                "Update Resume",
                "Add recent NiFi and Java projects",
                true,
                LocalDateTime.now().minusDays(7),
                LocalDateTime.now().minusDays(4)
        ));
    }

    @Override
    public List<Todo> findAll() {
        return todos;
    }

    @Override
    public void addTodo(Todo todo) {
        this.todos.add(todo);
    }

    @Override
    public void updateTodo(Todo todo, Long id) {
       // logic to remove todo from list using value of id
        todos.removeIf(todos -> todos.getId().equals(id));
        todos.add(todo);


    }
}