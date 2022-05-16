package com.example.wwwjava.repositories;

import com.example.wwwjava.models.Order;
import com.example.wwwjava.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
