package com.seiryu.ecommerce.backend_ecommerce.infrastructure.adapter;

import org.springframework.stereotype.Repository;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.Product;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.IProductRepository;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.mapper.IProductMapper;

@Repository
public class ProductCrudRepositoryImpl implements IProductRepository {

    private final IProductCrudRepository iProductCrudRepository;
    private final IProductMapper iProductMapper;

    public ProductCrudRepositoryImpl(IProductCrudRepository iProductCrudRepository, IProductMapper iProductMapper) {
        this.iProductCrudRepository = iProductCrudRepository;
        this.iProductMapper = iProductMapper;
    }

    @Override
    public Product save(Product product) {

        return iProductMapper.toProduct(iProductCrudRepository.save(iProductMapper.toProductEntity(product)));

    }

    @Override
    public Iterable<Product> findAll() {

        return iProductMapper.toProductList(iProductCrudRepository.findAll());

    }

    @Override
    public Product findById(Long id) {

        return iProductMapper.toProduct(iProductCrudRepository.findById(id).orElse(null));

    }

    @Override
    public void deleteById(Long id) {

        iProductCrudRepository.findById(id);
        iProductCrudRepository.deleteById(id);

    }

    @Override
    public boolean existById(Long id) {

        return iProductCrudRepository.existsById(id);
    }

}
