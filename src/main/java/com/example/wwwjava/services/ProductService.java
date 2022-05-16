package com.example.wwwjava.services;

import com.example.wwwjava.models.ProductDTO;

import java.util.List;

public interface ProductService {
    public ProductDTO getProductById(Long id);
    public List<ProductDTO> getAllProducts();
    public void deleteProductById(Long id);
    public ProductDTO saveProduct(ProductDTO product);
}
