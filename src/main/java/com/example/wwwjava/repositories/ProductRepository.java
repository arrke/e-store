package com.example.wwwjava.repositories;

import com.example.wwwjava.models.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDTO, Long> {
}
