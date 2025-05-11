package com.example.reactive_ecommerce.service;


import com.example.reactive_ecommerce.client.CartClient;
import com.example.reactive_ecommerce.dto.Payment;
import com.example.reactive_ecommerce.dto.Product;
import com.example.reactive_ecommerce.dto.ProductItem;
import com.example.reactive_ecommerce.dto.Shipment;
import com.example.reactive_ecommerce.model.Cart;
import com.example.reactive_ecommerce.model.CartItem;
import com.example.reactive_ecommerce.repository.CartRepository;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

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

    public Mono<Cart> removeItem(String userId, String itemId) {
        return repository.findByUserId(userId)
            .flatMap(cart -> {
                cart.getItems().removeIf(item -> item.getId().equals(itemId));
                return repository.save(cart);
            });
    }
    public Mono<Shipment> createShipment(String userId) {
        return repository.findByUserId(userId)
            .flatMap(cart -> {
                Shipment shipment = new Shipment();
                shipment.setId(UUID.randomUUID().toString());
                shipment.setOrderId(UUID.randomUUID().toString());
                shipment.setUserId(userId);
                shipment.setItems(
                        cart.getItems().stream()
                        .map(cartItem -> {
                            ProductItem productItem = new ProductItem();
                            productItem.setId(cartItem.getId());
                            productItem.setName(cartItem.getName());
                            productItem.setQuantity(cartItem.getQuantity());
                            return productItem;
                        })
                        .toList());
                shipment.setAddress("New Delhi, India");
                return cartClient.createShipment(shipment);
            });
    }

    public Mono<Payment> pay(String userId, String orderId, double amount) {
        Payment payment = new Payment();
        payment.setId(UUID.randomUUID().toString());
        payment.setUserId(userId);
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setStatus("PENDING");

        return cartClient.pay(payment);
    }
}
