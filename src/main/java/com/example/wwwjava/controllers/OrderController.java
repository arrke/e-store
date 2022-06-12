package com.example.wwwjava.controllers;

import com.example.wwwjava.models.*;
import com.example.wwwjava.repositories.CartRepository;
import com.example.wwwjava.repositories.UserRepository;
import com.example.wwwjava.dao.OrderItemDao;
import com.example.wwwjava.dao.OrderDao;
import com.example.wwwjava.dao.ProductDao;
import com.example.wwwjava.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.Set;

@Controller
public class OrderController {
    private static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private CartRepository cart;

    @Autowired
    private OrderDao orderService;

    @Autowired
    private ProductDao productService;

    @Autowired
    private OrderItemDao orderItemService;
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/order/create")
    public String createOrder(Model model){
        Map<Product, Integer> products =  cart.getProductsInCart();
        Order order = new Order();
        User user = getCurrentUser();
        Set<Order> userOrders = user.getOrders();
        userOrders.add(order);
        user.setOrders(userOrders);
        order = orderService.save(order);
        for(Map.Entry<Product, Integer> entry : products.entrySet()){
            ProductDTO product = productService.getProductById(entry.getKey().getId());
            Integer quantity = entry.getValue();
            orderItemService.save(new OrderItem(product, quantity, order));
        }
        order.setTotal(cart.getTotal());
        orderService.save(order);
        logger.info("order saved");
        emailService.sendMail(user.getEmail(), order.getId());
        logger.info("email sendes to admin");

        cart.clearCart();
        logger.info("cart cleared");
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model){
        model.addAttribute("orders", getCurrentUser().getOrders());
        logger.info("get all orders method in use");
        return "orders/index";
    }

    @GetMapping("/orders/{id}")
    public String getOrder(@PathVariable(value="id") Long id, Model model){
        Set<Order> orders =  getCurrentUser().getOrders();
        Order order = orders.stream().filter(order1 -> order1.getId() == id).findFirst().get();
        model.addAttribute("items", order.getItems());
        model.addAttribute("order", order);
        logger.info("get specific order");
        return "orders/show";
    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userRepository.getUserByUsername(currentPrincipalName);
        logger.info("get uder method in use");
        return user;
    }
}
