package com.example.demo.schema;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Order extends BaseEntity {
    // ech order has id, user details(which users order is this), and list of products their in that order


    private OrderStatus status;

//    @ManyToMany
//    @JoinTable(
//            name="order_product",
//            joinColumns = @JoinColumn(name="order_id") ,// the FK belonging to the same schema
//            inverseJoinColumns = @JoinColumn(name="product_id")// the FK belonging to product schema
//    )



}
