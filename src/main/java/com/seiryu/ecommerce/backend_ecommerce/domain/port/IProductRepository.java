package com.seiryu.ecommerce.backend_ecommerce.domain.port;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.Product;

public interface IProductRepository {

    public Product save(Product product);

    public Iterable<Product> findAll();

    public Product findById(Long id);

    public void deleteById(Long id);

    public boolean existById(Long id);

}
