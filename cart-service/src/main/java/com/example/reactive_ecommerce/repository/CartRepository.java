package com.example.reactive_ecommerce.repository;


import com.example.reactive_ecommerce.model.Cart;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CartRepository extends ReactiveMongoRepository<Cart, String> {
    Mono<Cart> findByUserId(String userId);
}
