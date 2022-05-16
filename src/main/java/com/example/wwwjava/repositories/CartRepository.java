package com.example.wwwjava.repositories;

import com.example.wwwjava.models.Product;
import com.example.wwwjava.models.ProductDTO;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
@Data
@Transactional
public class  CartRepository {

    private Map<Product, Integer> products;

    public CartRepository(){
        this.products = new HashMap<>();
    }
    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }

    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }
    }

    public Map<Product, Integer> getProductsInCart() {
        return products;
    }

    public void clearCart(){
        this.products.clear();
    }

    public BigDecimal getTotal() {
        return products.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }


}
