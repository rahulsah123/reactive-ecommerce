package com.example.reactive_ecommerce.service;


import com.example.reactive_ecommerce.model.Cart;
import com.example.reactive_ecommerce.model.CartItem;
import com.example.reactive_ecommerce.repository.CartRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CartService {
    private final CartRepository repository;

    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    public Mono<Cart> getCart(String userId) {
        return repository.findByUserId(userId);
    }

    public Mono<Cart> addToCart(String userId, CartItem item) {
        return repository.findByUserId(userId)
            .flatMap(cart -> {
                cart.getItems().add(item);
                return repository.save(cart);
            })
            .switchIfEmpty(repository.save(new Cart(null, userId, List.of(item))));
    }
}
