package com.seiryu.ecommerce.backend_ecommerce.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderProduct {

    private Long id;
    private BigDecimal quantity;
    private BigDecimal price;
    private Long productId;

    public BigDecimal getTotalItem() {
        return this.price.multiply(this.quantity);
    }

}
