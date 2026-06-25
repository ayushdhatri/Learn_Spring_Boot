package com.example.demo.services;


import com.example.demo.dtos.CreateOrderRequestDTO;
import com.example.demo.dtos.GetOrderResponseDTO;
import com.example.demo.repositories.OrderProductRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.schema.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final ProductRepository productRepository;

    public List<GetOrderResponseDTO> getAllOrders(){
        List<Order> orders = orderRepository.findAll();// this is order we need to convert to orderResponseDTO
        // here we will use adapter design pattern because order and getOrderResponseDTO have different strcuture


    }

    public boolean createOrder(CreateOrderRequestDTO createOrderRequestDTO){
        // create order entity out of dto and save it
        Order newOrder = Order.builder().build();
        this.orderRepository.save(newOrder);
        return true;
    }

    public boolean deleteOrder(Long id){
        this.orderRepository.deleteById(id);
        return true;
    }

}
