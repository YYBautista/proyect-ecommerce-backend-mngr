package com.seiryu.ecommerce.backend_ecommerce.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.Category;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {

    @Mappings({ @Mapping(source = "id", target = "id"), @Mapping(source = "name", target = "name"),
            @Mapping(source = "dateCreated", target = "dateCreated"),
            @Mapping(source = "dateUpdated", target = "dateUpdated") })

    public Category toCategory(CategoryEntity categoryEntity);

    public Iterable<Category> toCategoryList(Iterable<CategoryEntity> categoryEntity);

    @InheritInverseConfiguration
    public CategoryEntity toCategoryEntity(Category category);

}
