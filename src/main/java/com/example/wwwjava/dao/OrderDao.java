package com.example.wwwjava.dao;

import com.example.wwwjava.models.Order;

import java.util.List;

public interface OrderDao {
    public Order getOrderById(Long id);

    public List<Order> getAllOrders();

    public Order save(Order o);
}
