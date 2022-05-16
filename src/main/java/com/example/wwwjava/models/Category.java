package com.example.wwwjava.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Size;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name= "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=2, max=20)
    private String name;

    @OneToMany(mappedBy="category")
    private List<ProductDTO> products;
}
