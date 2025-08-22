package com.seiryu.ecommerce.backend_ecommerce.application;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.Order;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.IOrderRepository;

public class OrderService {

    private final IOrderRepository iOrderRepository;

    public OrderService(IOrderRepository iOrderRepository) {

        this.iOrderRepository = iOrderRepository;
    }

    public Order save(Order order) {

        return this.iOrderRepository.save(order);
    }

    public Iterable<Order> findAll() {

        return this.iOrderRepository.findAll();
    }

    public Iterable<Order> findByUserId(Long userId) {

        return this.iOrderRepository.findByUserId(userId);
    }

    public void updateStateById(Long id, String state) {

        this.iOrderRepository.updateStateById(id, state);
    }

    public Order findById(Long id) {
        return this.iOrderRepository.findById(id);
    }

}
