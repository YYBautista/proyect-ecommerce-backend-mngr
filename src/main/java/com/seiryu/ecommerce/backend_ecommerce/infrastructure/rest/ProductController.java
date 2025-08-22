package com.seiryu.ecommerce.backend_ecommerce.infrastructure.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.seiryu.ecommerce.backend_ecommerce.application.ProductsService;
import com.seiryu.ecommerce.backend_ecommerce.domain.model.Product;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1/admin/products")
@Slf4j
public class ProductController {

    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> save(@RequestParam("id") Long id, @RequestParam("code") String code,
            @RequestParam("name") String name, @RequestParam("description") String description,
            @RequestParam("price") BigDecimal price, @RequestParam("urlImage") String urlImage,
            @RequestParam("userId") Long userId, @RequestParam("idCategory") Long idCategory,
            @RequestParam(value = "image", required = false) MultipartFile multipartFile

    ) throws IOException {

        Product product = new Product();

        if (!this.productsService.existByid(id)) {

            product.setCode(code);
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setUrlImage(urlImage);
            product.setUserId(userId);
            product.setIdCategory(idCategory);

        } else {
            product.setId(id);
            product.setCode(code);
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setUrlImage(urlImage);
            product.setUserId(userId);
            product.setIdCategory(idCategory);
        }

        log.info("name: {}", product.getName());

        return new ResponseEntity<>(productsService.save(product, multipartFile), HttpStatus.CREATED);
    }

    @GetMapping("/listProducts")
    public ResponseEntity<Iterable<Product>> findAll() {
        return new ResponseEntity<>(productsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findProduct/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return new ResponseEntity<>(productsService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        productsService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
