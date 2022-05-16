package com.example.wwwjava.services;

import com.example.wwwjava.models.Order;

import java.util.List;

public interface OrderService {
    public Order getOrderById(Long id);

    public List<Order> getAllOrders();

    public Order save(Order o);
}
