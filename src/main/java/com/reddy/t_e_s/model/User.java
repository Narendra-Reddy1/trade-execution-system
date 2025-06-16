package com.reddy.t_e_s.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotNull(message = "username required")
    @Column(nullable = false, unique = true)
    private String username;

    @Email(message = "Invalid email format")
    @NotNull(message = "Email is required ")
    @Column(nullable = false, unique = true)
    private String email;

    @Min(value = 0, message = "Balance cannot be negative")
    @Column(nullable = false)
    private long balance = 0L;

    @CreationTimestamp
    private String created_at;

}
