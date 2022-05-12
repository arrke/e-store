package com.example.wwwjava.repositories;

import com.example.wwwjava.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
