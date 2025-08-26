package com.seiryu.ecommerce.backend_ecommerce.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seiryu.ecommerce.backend_ecommerce.application.ProductsService;
import com.seiryu.ecommerce.backend_ecommerce.domain.model.Product;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {

    private final ProductsService productsService;

    public HomeController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/listProducts")
    public ResponseEntity<Iterable<Product>> findAll() {
        return new ResponseEntity<>(productsService.findAll(), HttpStatus.OK);
    }

}
