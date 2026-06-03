package com.example.demo.schema;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto-increment specially for mysql
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private String image;
    private String category;
    private String rating;


}
