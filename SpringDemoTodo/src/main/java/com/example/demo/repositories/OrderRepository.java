package com.example.demo.repositories;

import com.example.demo.dtos.CreateOrderRequestDTO;
import com.example.demo.schema.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
