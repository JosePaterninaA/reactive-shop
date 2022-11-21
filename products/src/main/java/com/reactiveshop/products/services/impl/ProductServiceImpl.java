package com.reactiveshop.products.services.impl;

import com.reactiveshop.products.entities.Product;
import com.reactiveshop.products.repositories.ProductRepository;
import com.reactiveshop.products.services.ProductService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> getAllProducts() {
        return productRepository
                .findAll();
    }

    @Override
    public Mono<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
