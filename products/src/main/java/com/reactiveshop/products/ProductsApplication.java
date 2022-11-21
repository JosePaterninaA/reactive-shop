package com.reactiveshop.products;

import com.reactiveshop.products.entities.Product;
import com.reactiveshop.products.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
@Slf4j
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

	@Autowired
	ProductRepository productRepository;

	@Bean
	ApplicationRunner setup(){
		return (args)->{
			log.info("Setup running");
			productRepository.deleteAll().thenMany(
			productRepository.saveAll(List.of(
									Product.builder().name("P1").description("d1").imageUrl("https://img1.png").build(),
									Product.builder().name("P2").description("d2").imageUrl("https://img2.png").build(),
									Product.builder().name("P3").description("d3").imageUrl("https://img3.png").build(),
									Product.builder().name("P4").description("d4").imageUrl("https://img4.png").build()
							))).subscribe((p)->log.info("saved product"));
		};
	}

}
