package com.seiryu.ecommerce.backend_ecommerce.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.User;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    @Mappings({ @Mapping(source = "id", target = "id"), @Mapping(source = "userName", target = "userName"),
            @Mapping(source = "firstName", target = "firstName"), @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "email", target = "email"), @Mapping(source = "address", target = "address"),
            @Mapping(source = "cellphone", target = "cellphone"), @Mapping(source = "password", target = "password"),
            @Mapping(source = "userType", target = "userType"),
            @Mapping(source = "dateCreated", target = "dateCreated"),
            @Mapping(source = "dateUpdated", target = "dateUpdated"),

    })
    public User toUser(UserEntity userEntity);

    public Iterable<User> toUser(Iterable<UserEntity> userEntity);

    @InheritInverseConfiguration
    public UserEntity toUserEntity(User user);

}
