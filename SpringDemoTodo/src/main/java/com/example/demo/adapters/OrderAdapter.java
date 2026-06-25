package com.example.demo.adapters;

import com.example.demo.dtos.GetOrderResponseDTO;
import com.example.demo.dtos.OrderItemResponseDTO;
import com.example.demo.repositories.OrderProductRepository;
import com.example.demo.schema.Order;
import com.example.demo.schema.OrderProducts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderAdapter {
    private final OrderProductRepository orderProductRepository;
    public  GetOrderResponseDTO mapToGetOrderResponseDTO(Order order){
        List<OrderProducts> orderProductsList = orderProductRepository.findByOrderId(order.getId()));
        return GetOrderResponseDTO.builder()
                .id(order.getId())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }

    public List<OrderItemResponseDTO> mapToOrderItemResponseDto(List<OrderProducts> orderProducts){
         return orderProducts.stream()
                .map(orderProduct -> {
                    return OrderItemResponseDTO.builder()
                            .productId(orderProduct.getProduct().getId())
                            .productName(orderProduct.getProduct().getTitle())
                            .productPrice(orderProduct.getProduct().getPrice())
                            .productImage(orderProduct.getProduct().getImage())
                            .subTotal(orderProduct.getProduct().getPrice().multiply(BigDecimal.valueOf(5)))
                            .build();
                }).toList();
    }
}
