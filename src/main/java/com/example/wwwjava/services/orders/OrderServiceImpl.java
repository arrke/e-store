package com.example.wwwjava.services.orders;

import com.example.wwwjava.models.Order;
import com.example.wwwjava.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order save(Order o) {
        return orderRepository.save(o);
    }
}
