package com.reddy.t_e_s.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "stocks")
public class Stock {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Symbol is requried")
    @Column(nullable = false, unique = true)
    private String symbol;

    @NotNull(message = "Stock name is required")
    @Column(nullable = false)
    private String name;

    @DecimalMin(value = "0.00", message = "Price cannot be negative")
    @Column(name = "current_price", nullable = false, precision = 18, scale = 2)
    private BigDecimal currentPrice;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
