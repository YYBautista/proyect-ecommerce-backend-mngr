package com.seiryu.ecommerce.backend_ecommerce.domain.port;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.Order;

public interface IOrderRepository {

    public Order save(Order order);

    public Order findById(Long id);

    public Iterable<Order> findAll();

    public Iterable<Order> findByUserId(Long userId);

    public void updateStateById(Long id, String state);

}
