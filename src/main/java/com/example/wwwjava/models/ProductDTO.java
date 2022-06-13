package com.example.wwwjava.models;

//import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.constraints.NotNull;

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

    @javax.validation.constraints.NotNull(message = "Cena musi zawierać się między 0.1 a 299.99")
    @DecimalMin("0.1")
    @DecimalMax("299.99")
   // @NotEmpty
   // @NotBlank(message = "Wpisz swoje hasło")
  //  @Length(min=6, message = "Cena musi zawierać się między 0.1 a 299.99")
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
