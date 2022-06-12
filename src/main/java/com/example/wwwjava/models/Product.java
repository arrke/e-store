package com.example.wwwjava.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private String categoryName;

    public Product(ProductDTO product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.categoryName = product.getCategory().getName();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
