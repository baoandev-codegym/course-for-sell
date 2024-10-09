package com.codegym.course_for_sell.repository;

import com.codegym.course_for_sell.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
