package com.seiryu.ecommerce.backend_ecommerce.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Order {

    private Long id;
    private LocalDateTime dateCreated;
    private List<OrderProduct> orderProducts;
    private OrderState orderState;
    private Long userId;

    public Order() {

        this.orderProducts = new ArrayList<>();
    }

    public BigDecimal getTotalOrderPrice() {
        return this.orderProducts.stream().map(orderProducts -> orderProducts.getTotalItem()).reduce(BigDecimal.ZERO,
                BigDecimal::add);
    }

}
