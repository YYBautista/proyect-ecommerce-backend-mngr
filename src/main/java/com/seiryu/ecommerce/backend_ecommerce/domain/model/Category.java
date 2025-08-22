package com.seiryu.ecommerce.backend_ecommerce.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    private Long id;
    private String name;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public Category() {
    }

    public Category(String name, LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.name = name;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated
                + "]";
    }

}
