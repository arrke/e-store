package com.example.wwwjava.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name="products")
public class ProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=4, max=20)
    private String name;

    @NotNull
    @DecimalMin("0.1")
    @DecimalMax("299.99")
    private BigDecimal price;

    @NotNull
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    @Valid
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        ProductDTO product = (ProductDTO) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
