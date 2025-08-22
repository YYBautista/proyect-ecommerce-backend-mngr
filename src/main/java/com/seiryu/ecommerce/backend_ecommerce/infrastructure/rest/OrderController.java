package com.seiryu.ecommerce.backend_ecommerce.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seiryu.ecommerce.backend_ecommerce.application.OrderService;
import com.seiryu.ecommerce.backend_ecommerce.domain.model.Order;
import com.seiryu.ecommerce.backend_ecommerce.domain.model.OrderState;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/orders")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        if (order.getOrderState().toString().equals(OrderState.CANCELLED.toString())) {

            order.setOrderState(OrderState.CANCELLED);

        } else {
            order.setOrderState(OrderState.CONFIRMED);

        }
        return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    @PostMapping("/update/state/order")
    public ResponseEntity<?> updateStateById(@RequestParam Long id, @RequestParam String state) {
        orderService.updateStateById(id, state);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/listOrders")
    public ResponseEntity<Iterable<Order>> findAll() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/ordersById/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/ordersByUserId/{userId}")
    public ResponseEntity<Iterable<Order>> findByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(orderService.findByUserId(userId), HttpStatus.OK);
    }

}
