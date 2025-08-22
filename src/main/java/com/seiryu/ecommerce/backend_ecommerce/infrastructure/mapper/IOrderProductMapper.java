package com.seiryu.ecommerce.backend_ecommerce.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.OrderProduct;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.entity.OrderProductEntity;

@Mapper(componentModel = "spring")
public interface IOrderProductMapper {

    @Mappings({

            @Mapping(source = "id", target = "id"), @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "price", target = "price"), @Mapping(source = "productId", target = "productId")

    })
    public OrderProduct toOrderProduct(OrderProductEntity orderProductEntity);

    public Iterable<OrderProduct> toOrderProductList(Iterable<OrderProductEntity> orderProductEntities);

    @InheritInverseConfiguration
    public OrderProductEntity toOrderProductEntity(OrderProduct orderProduct);

}
