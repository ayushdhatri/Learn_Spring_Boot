package com.example.demo.services;


import com.example.demo.dtos.CreateOrderRequestDTO;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.schema.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public boolean createOrder(CreateOrderRequestDTO createOrderRequestDTO){
        // create order entity out of dto and save it
        Order newOrder = Order.builder().products(createOrderRequestDTO.getProducts()).build();
        this.orderRepository.save(newOrder);
        return true;
    }

    public boolean deleteOrder(Long id){
        this.orderRepository.deleteById(id);
        return true;
    }

}
