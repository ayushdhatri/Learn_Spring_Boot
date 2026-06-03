package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class CreateProductRequestDto {
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;

}
