package com.example.demo.schema;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

//@Entity
@AllArgsConstructor
public class Todo {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Todo() {

    }
}