package com.example.reactive_ecommerce.service;


import com.example.reactive_ecommerce.client.CartClient;
import com.example.reactive_ecommerce.dto.Product;
import com.example.reactive_ecommerce.model.Cart;
import com.example.reactive_ecommerce.model.CartItem;
import com.example.reactive_ecommerce.repository.CartRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CartService {
    private final CartRepository repository;
    private final CartClient cartClient;

    public CartService(CartRepository repository, CartClient cartClient) {
        this.repository = repository;
        this.cartClient = cartClient;
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

    public Flux<Product> receiverProducts(){
        return cartClient.receiverProducts();
    }
}
