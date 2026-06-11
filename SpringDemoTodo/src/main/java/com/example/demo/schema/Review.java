package com.example.demo.schema;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql="UPDATE reviews SET deleted_at = CURRENT_TIMESTAMP where id = ?")
@SQLRestriction("WHERE deleted_at IS NULL")
@Table(name = "reviews")
@Data
public class Review extends BaseEntity{
    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    @Column(nullable = false)
    private BigDecimal rating;

}