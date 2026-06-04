package com.example.demo.dtos;

import com.example.demo.schema.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class CreateProductRequestDto {
    private String name;
    private String title;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private Long categoryId;

}
