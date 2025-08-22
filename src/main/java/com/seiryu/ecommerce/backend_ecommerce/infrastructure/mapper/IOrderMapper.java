package com.seiryu.ecommerce.backend_ecommerce.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.Order;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.entity.OrderEntity;

//para varios mappers de clases  es : @Mapper(componentModel = "spring", uses = {IOrderProductMapper.class, ...})
@Mapper(componentModel = "spring", uses = IOrderProductMapper.class)
public interface IOrderMapper {

    @Mappings({ @Mapping(source = "id", target = "id"), @Mapping(source = "dateCreated", target = "dateCreated"),
            @Mapping(source = "orderProducts", target = "orderProducts"),
            @Mapping(source = "orderState", target = "orderState"),
            @Mapping(source = "userEntity.id", target = "userId") })
    public Order toOrder(OrderEntity orderEntity);

    public Iterable<Order> toOrderList(Iterable<OrderEntity> orderEntities);

    @InheritInverseConfiguration
    public OrderEntity toOrderEntity(Order order);

}
