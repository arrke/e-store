package com.example.wwwjava.controllers;

import com.example.wwwjava.models.Product;
import com.example.wwwjava.models.ProductDTO;
import com.example.wwwjava.repositories.CartRepository;
import com.example.wwwjava.repositories.CategoryRepository;
import com.example.wwwjava.services.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class CartController {

    private static Logger logger = LoggerFactory.getLogger(CartController.class);
    @Autowired
    private CartRepository cart;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable(value="id") Long id){
        ProductDTO productDTO = productService.getProductById(id);
        Product product = new Product(productDTO);
        cart.addProduct(product);
        logger.info("added to cart");
        return "redirect:/";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable(value="id") Long id){
        ProductDTO productDTO = productService.getProductById(id);
        Product product = new Product(productDTO);
        cart.removeProduct(product);
        logger.info("removed from cart");
        return "redirect:/cart";
    }
    @GetMapping("/cart")
    public String showCart(Model model){
        Map<Product, Integer> products =  cart.getProductsInCart();
        model.addAttribute("products",products);
        model.addAttribute("totalPrice", cart.getTotal().toString());
        logger.info("cart show");
        return "cart/index";
    }

}
