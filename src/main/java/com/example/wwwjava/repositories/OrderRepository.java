package com.example.wwwjava.repositories;

import com.example.wwwjava.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
