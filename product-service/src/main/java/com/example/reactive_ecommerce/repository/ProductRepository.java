package com.example.reactive_ecommerce.repository;

import com.example.reactive_ecommerce.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
