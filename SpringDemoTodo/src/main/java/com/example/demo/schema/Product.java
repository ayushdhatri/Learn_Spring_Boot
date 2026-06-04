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
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String title;
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    private String image;
    private String category;
    private String rating;


}
