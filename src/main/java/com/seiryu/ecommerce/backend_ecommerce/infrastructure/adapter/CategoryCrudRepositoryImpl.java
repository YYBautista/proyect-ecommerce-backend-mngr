package com.seiryu.ecommerce.backend_ecommerce.infrastructure.adapter;

import org.springframework.stereotype.Repository;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.Category;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.ICategoryRepository;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.mapper.ICategoryMapper;

@Repository
public class CategoryCrudRepositoryImpl implements ICategoryRepository {

    private final ICategoryCrudRepository icategoryCrudRepository;
    private final ICategoryMapper iCategoryMapper;

    public CategoryCrudRepositoryImpl(ICategoryCrudRepository icategoryCrudRepository,
            ICategoryMapper iCategoryMapper) {
        this.icategoryCrudRepository = icategoryCrudRepository;
        this.iCategoryMapper = iCategoryMapper;
    }

    @Override
    public Category save(Category category) {

        return iCategoryMapper.toCategory(icategoryCrudRepository.save(iCategoryMapper.toCategoryEntity(category)));

    }

    @Override
    public Iterable<Category> findAll() {

        return iCategoryMapper.toCategoryList(icategoryCrudRepository.findAll());

    }

    @Override
    public Category findById(Long id) {

        return iCategoryMapper.toCategory(icategoryCrudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría con id: " + id + " no existe")));

    }

    @Override
    public void deleteById(Long id) {

        icategoryCrudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría con id: " + id + " no existe"));
        icategoryCrudRepository.deleteById(id);

    }

}
