package com.seiryu.ecommerce.backend_ecommerce.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String code;
    private String description;
    private String urlImage;
    private BigDecimal price;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private Long userId;
    private Long idCategory;

    public Product() {
    }

    public Product(String name, String code, String description, String urlImage, BigDecimal price,
            LocalDateTime dateCreated, LocalDateTime dateUpdated, Long userId, Long idCategory) {

        this.name = name;
        this.code = code;
        this.description = description;
        this.urlImage = urlImage;
        this.price = price;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.userId = userId;
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", code=" + code + ", description=" + description
                + ", urlImage=" + urlImage + ", price=" + price + ", dateCreated=" + dateCreated + ", dateUpdated="
                + dateUpdated + ", userId=" + userId + ", idCategory=" + idCategory + "]";
    }

}
