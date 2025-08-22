package com.seiryu.ecommerce.backend_ecommerce.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.Product;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    @Mappings({ @Mapping(source = "id", target = "id"), @Mapping(source = "name", target = "name"),
            @Mapping(source = "code", target = "code"), @Mapping(source = "description", target = "description"),
            @Mapping(source = "urlImage", target = "urlImage"), @Mapping(source = "price", target = "price"),
            @Mapping(source = "dateCreated", target = "dateCreated"),
            @Mapping(source = "dateUpdated", target = "dateUpdated"),
            @Mapping(source = "userEntity.id", target = "userId"),
            @Mapping(source = "categoryEntity.id", target = "idCategory")

    })
    public Product toProduct(ProductEntity productEntity);

    public Iterable<Product> toProductList(Iterable<ProductEntity> productEntity);

    @InheritInverseConfiguration
    public ProductEntity toProductEntity(Product product);

}
