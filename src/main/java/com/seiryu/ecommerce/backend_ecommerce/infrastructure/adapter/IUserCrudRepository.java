package com.seiryu.ecommerce.backend_ecommerce.infrastructure.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seiryu.ecommerce.backend_ecommerce.infrastructure.entity.UserEntity;

public interface IUserCrudRepository extends JpaRepository<UserEntity, Long> {

}
