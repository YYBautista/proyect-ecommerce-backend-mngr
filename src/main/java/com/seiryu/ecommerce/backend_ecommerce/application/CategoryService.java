package com.seiryu.ecommerce.backend_ecommerce.application;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.Category;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.ICategoryRepository;

public class CategoryService {

    private final ICategoryRepository iCategoryRepository;

    public CategoryService(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    public Category save(Category category) {

        return this.iCategoryRepository.save(category);
    }

    public Iterable<Category> findAll() {
        return this.iCategoryRepository.findAll();
    }

    public Category findById(Long id) {
        return this.iCategoryRepository.findById(id);

    }

    public void deleteById(Long id) {
        this.iCategoryRepository.deleteById(id);
    }

}
