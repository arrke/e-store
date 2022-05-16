package com.example.wwwjava.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="order_items")
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private ProductDTO product;

    private Integer quantity;

    public OrderItem(){}
    public OrderItem(ProductDTO product, Integer quantity, Order order){
        this.product = product;
        this.quantity = quantity;
        this.order = order;
    }



}
