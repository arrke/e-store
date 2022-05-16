package com.example.wwwjava.services;

import com.example.wwwjava.models.OrderItem;
import com.example.wwwjava.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem save(OrderItem it) {
        return orderItemRepository.save(it);
    }
}
