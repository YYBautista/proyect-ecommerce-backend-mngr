package com.seiryu.ecommerce.backend_ecommerce.infrastructure.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seiryu.ecommerce.backend_ecommerce.application.CategoryService;
import com.seiryu.ecommerce.backend_ecommerce.domain.model.Category;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/admin/categories")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/createCategory")
    public ResponseEntity<Category> save(@RequestBody Category category) {

        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @GetMapping("/listCategories")
    public ResponseEntity<Iterable<Category>> findAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findCategory/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {

        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);

    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {

        categoryService.deleteById(id);
        return ResponseEntity.ok().build();

    }

}
