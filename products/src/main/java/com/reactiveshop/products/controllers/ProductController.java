package com.reactiveshop.products.controllers;

import com.reactiveshop.products.entities.Product;
import com.reactiveshop.products.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/", produces = TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> allProducts(){
        return productService.getAllProducts().delayElements(Duration.ofSeconds(1));
    }
}
