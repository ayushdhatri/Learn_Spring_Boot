package com.example.demo.dtos;

import com.example.demo.schema.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetOrderResponseDTO {
    private Long id;

    private OrderStatus status;

    private List<OrderItemResponseDTO> items;

    private LocalDateTime updatedAt;

    private LocalDateTime createdAt;
}
