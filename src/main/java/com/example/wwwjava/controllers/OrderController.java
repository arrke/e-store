package com.example.wwwjava.controllers;

import com.example.wwwjava.models.Order;
import com.example.wwwjava.models.OrderItem;
import com.example.wwwjava.models.Product;
import com.example.wwwjava.models.ProductDTO;
import com.example.wwwjava.repositories.CartRepository;
import com.example.wwwjava.repositories.ProductRepository;
import com.example.wwwjava.services.OrderItemService;
import com.example.wwwjava.services.OrderService;
import com.example.wwwjava.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    private CartRepository cart;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/order/create")
    public String createOrder(Model model){
        Map<Product, Integer> products =  cart.getProductsInCart();
        Order order = orderService.save(new Order());
        for(Map.Entry<Product, Integer> entry : products.entrySet()){
            ProductDTO product = productService.getProductById(entry.getKey().getId());
            Integer quantity = entry.getValue();
            orderItemService.save(new OrderItem(product, quantity, order));
        }
        order.setTotal(cart.getTotal());
        orderService.save(order);
        cart.clearCart();
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model){
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders/index";
    }

    @GetMapping("/orders/{id}")
    public String getOrder(@PathVariable(value="id") Long id, Model model){
        Order order = orderService.getOrderById(id);
        model.addAttribute("items", order.getItems());
        model.addAttribute("order", order);
        return "orders/show";
    }
}
