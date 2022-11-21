package com.reactiveshop.products.services;

import com.reactiveshop.products.entities.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> getAllProducts();
    Mono<Product> getProductById(Long id);
}
