package com.seiryu.ecommerce.backend_ecommerce.application;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.seiryu.ecommerce.backend_ecommerce.domain.model.Product;
import com.seiryu.ecommerce.backend_ecommerce.domain.port.IProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductsService {

    private final IProductRepository iProductRepository;
    private final UploadFile uploadFile;

    public ProductsService(IProductRepository iProductRepository, UploadFile uploadFile) {
        this.iProductRepository = iProductRepository;
        this.uploadFile = uploadFile;
    }

    public Product save(Product product, MultipartFile multipartFile) throws IOException {

        if (product.getId() != null) { // cuando es un producto modificacdo

            if (multipartFile == null) {
                product.setUrlImage(product.getUrlImage());

            } else {
                System.out.println("url: " + product.getUrlImage());
                String nameFile = product.getUrlImage().substring(29);

                log.info("Este es el nombre de la imagen : {}", nameFile);

                if (!nameFile.equals("default.jpg")) {
                    uploadFile.deleteImage(nameFile);
                }

                product.setUrlImage(uploadFile.upload(multipartFile));
            }

        } else {
            product.setUrlImage(uploadFile.upload(multipartFile));
        }

        return this.iProductRepository.save(product);
    }

    public Iterable<Product> findAll() {
        return this.iProductRepository.findAll();

    }

    public Product findById(Long id) {
        return this.iProductRepository.findById(id);
    }

    public void deleteById(Long id) {

        Product product = findById(id);

        String nameFile = product.getUrlImage().substring(29);

        log.info("Este es el nombre de la imagen : {}", nameFile);

        if (!nameFile.equals("default.jpg")) {
            uploadFile.deleteImage(nameFile);
        }

        this.iProductRepository.deleteById(id);
    }

    public boolean existByid(long id) {

        return this.iProductRepository.existById(id);

    }

}
