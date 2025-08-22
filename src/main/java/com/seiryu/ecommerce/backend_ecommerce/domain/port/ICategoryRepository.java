package com.seiryu.ecommerce.backend_ecommerce.domain.port;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.Category;

public interface ICategoryRepository {

    public Category save(Category category);

    public Iterable<Category> findAll();

    public Category findById(Long id);

    public void deleteById(Long id);

}
