package com.reddy.t_e_s.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Side side;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_type", nullable = false)
    private OrderType orderType;

    @Column(nullable = false)
    private Integer quantity;

    @Column(precision = 18, scale = 2)
    private BigDecimal price;


    @Column(name = "remaining_quantity", nullable = false)
    private Integer remaining_quantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus orderStatus;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;


}

enum OrderStatus {
    PENDING,
    EXECUTED,
    PARTIALLY_EXECUTED,
    CANCELLED

}

enum Side {
    BUY,
    SELL
}

enum OrderType {
    MARKET,
    LIMIT
}