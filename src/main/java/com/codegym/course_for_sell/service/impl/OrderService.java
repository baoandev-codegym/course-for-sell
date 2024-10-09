package com.codegym.course_for_sell.service.impl;

import com.codegym.course_for_sell.repository.IOrderRepository;
import com.codegym.course_for_sell.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService implements IOrderService {
    private final IOrderRepository orderRepository;


}
