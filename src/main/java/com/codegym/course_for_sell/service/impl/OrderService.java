package com.codegym.course_for_sell.service.impl;

import com.codegym.course_for_sell.converter.IOrderConverter;
import com.codegym.course_for_sell.entity.Order;
import com.codegym.course_for_sell.payload.response.OrderResponseDTO;
import com.codegym.course_for_sell.repository.IOrderRepository;
import com.codegym.course_for_sell.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService implements IOrderService {
    private final IOrderRepository orderRepository;

    @Override
    public Iterable<OrderResponseDTO> findAllOrder() {
        List<Order> orders = orderRepository.findAll();
        return orderConverter.mapOrderToOrderResponseDTO(orders);
    }
}
