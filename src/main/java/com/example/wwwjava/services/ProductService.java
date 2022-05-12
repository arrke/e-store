package com.example.wwwjava.services;

import com.example.wwwjava.models.Category;
import com.example.wwwjava.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(Long id);
    public List<Product> getAllProducts();
    public void deleteProductById(Long id);
    public Product saveProduct(Product product);
}
