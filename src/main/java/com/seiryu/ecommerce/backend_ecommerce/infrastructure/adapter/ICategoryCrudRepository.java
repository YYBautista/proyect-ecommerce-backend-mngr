package com.seiryu.ecommerce.backend_ecommerce.infrastructure.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seiryu.ecommerce.backend_ecommerce.infrastructure.entity.CategoryEntity;

public interface ICategoryCrudRepository extends JpaRepository<CategoryEntity, Long> {

}
