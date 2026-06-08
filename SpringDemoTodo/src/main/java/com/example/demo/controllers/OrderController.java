package com.example.demo.controllers;


import com.example.demo.dtos.CreateOrderRequestDTO;
import com.example.demo.services.OrderService;
import com.example.demo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    // Create Order
    @PostMapping
    public boolean createOrder(CreateOrderRequestDTO createOrderRequestDTO){
        return orderService.createOrder(createOrderRequestDTO);
    }

    // Delete Order

    // Add product to Order(this is like update the existing order)

    // Remove product from Order(this is like update the existing order)
}
