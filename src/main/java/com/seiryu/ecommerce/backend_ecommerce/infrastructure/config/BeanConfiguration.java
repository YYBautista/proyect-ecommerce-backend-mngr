package com.seiryu.ecommerce.backend_ecommerce.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seiryu.ecommerce.backend_ecommerce.application.CategoryService;
import com.seiryu.ecommerce.backend_ecommerce.application.OrderService;
import com.seiryu.ecommerce.backend_ecommerce.application.ProductsService;
import com.seiryu.ecommerce.backend_ecommerce.application.UploadFile;
import com.seiryu.ecommerce.backend_ecommerce.application.UserService;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.ICategoryRepository;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.IOrderRepository;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.IProductRepository;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.IUserRepository;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserService userService(IUserRepository iUserRepository) {
        return new UserService(iUserRepository);

    }

    @Bean
    public CategoryService categoryService(ICategoryRepository icategoryRepository) {
        return new CategoryService(icategoryRepository);
    }

    @Bean
    public ProductsService productsService(IProductRepository iProductRepository, UploadFile uploadFile) {
        return new ProductsService(iProductRepository, uploadFile);
    }

    @Bean
    public OrderService orderService(IOrderRepository iOrderRepository) {

        return new OrderService(iOrderRepository);

    }

    @Bean
    public UploadFile uploadFile() {
        return new UploadFile();
    }

}
