package com.seiryu.ecommerce.backend_ecommerce.infrastructure.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.OrderState;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.entity.OrderEntity;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.entity.UserEntity;

import jakarta.transaction.Transactional;

public interface IOrderCrudRepository extends JpaRepository<OrderEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.orderState = :state WHERE o.id = :id")
    public void updateStateById(Long id, OrderState state);

    public Iterable<OrderEntity> findByUserEntity(UserEntity userEntity);

}
