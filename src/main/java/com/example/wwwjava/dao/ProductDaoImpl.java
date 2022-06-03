package com.example.wwwjava.dao;

import com.example.wwwjava.models.ProductDTO;
import com.example.wwwjava.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO product) {
        return productRepository.save(product);
    }
}
