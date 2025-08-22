package com.seiryu.ecommerce.backend_ecommerce.infrastructure.adapter;

import org.springframework.stereotype.Repository;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.Order;
import com.seiryu.ecommerce.backend_ecommerce.domain.model.OrderState;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.IOrderRepository;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.entity.OrderEntity;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.entity.UserEntity;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.mapper.IOrderMapper;

@Repository
public class OrderCrudRepositoryImpl implements IOrderRepository {

    private final IOrderMapper iOrderMapper;
    private final IOrderCrudRepository iOrderCrudRepository;

    public OrderCrudRepositoryImpl(IOrderMapper iOrderMapper, IOrderCrudRepository iOrderCrudRepository) {

        this.iOrderMapper = iOrderMapper;
        this.iOrderCrudRepository = iOrderCrudRepository;
    }

    @Override
    public Order save(Order order) {

        OrderEntity orderEntity = iOrderMapper.toOrderEntity(order);

        orderEntity.getOrderProducts().forEach(orderProductEntity -> orderProductEntity.setOrderEntity(orderEntity));

        return iOrderMapper.toOrder(iOrderCrudRepository.save(orderEntity));

    }

    @Override
    public Order findById(Long id) {

        return iOrderMapper.toOrder(iOrderCrudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden con id: " + id + " no encontrada")));

    }

    @Override
    public Iterable<Order> findAll() {

        return iOrderMapper.toOrderList(iOrderCrudRepository.findAll());
    }

    @Override
    public Iterable<Order> findByUserId(Long userId) {

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        return iOrderMapper.toOrderList(iOrderCrudRepository.findByUserEntity(userEntity));

    }

    @Override
    public void updateStateById(Long id, String state) {

        if (state.equals(OrderState.CANCELLED.name())) {
            iOrderCrudRepository.updateStateById(id, OrderState.CANCELLED);
        } else {
            iOrderCrudRepository.updateStateById(id, OrderState.CONFIRMED);
        }

    }

}
