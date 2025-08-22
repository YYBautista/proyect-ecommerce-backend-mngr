package com.seiryu.ecommerce.backend_ecommerce.infrastructure.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "order_products")
public class OrderProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal quantity;
    private BigDecimal price;
    private Long productId;
    @ManyToOne
    private OrderEntity orderEntity;

    public OrderProductEntity() {
    }

}
