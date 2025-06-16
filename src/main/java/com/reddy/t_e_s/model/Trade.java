package com.reddy.t_e_s.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "trades")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buy_order_id", nullable = false)
    private Order buyOrder;

    @ManyToOne
    @JoinColumn(name = "sell_order_id", nullable = false)
    private Order sellOrder;


    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @CreationTimestamp
    private LocalDateTime executed_at;
}
