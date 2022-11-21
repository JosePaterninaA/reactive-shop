package com.reactiveshop.products.repositories;

import com.reactiveshop.products.entities.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, Long> {
}
