package com.example.wwwjava.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    @NotEmpty
    @NotBlank(message = "Wpisz swój email")
    @Email(message="Wpisz poprawny email")
    @Size(min=5, max=50)
    private String email;

    @Column(nullable = false, length = 64)
    @NotEmpty
    @NotBlank(message = "Wpisz swoje hasło")
    @Length(min=6, message = "Hasło musi zawierać co najmniej 6 znaków")
    private String password;

    @Column(name = "first_name", nullable = false, length = 20)
    @NotEmpty
    @NotBlank(message = "Wprowadź imie")
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    @NotEmpty
    @NotBlank(message = "Wprowadź nazwisko")

    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private Set<Order> orders = new HashSet<>();
}