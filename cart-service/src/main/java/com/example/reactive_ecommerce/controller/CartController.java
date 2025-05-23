package com.example.reactive_ecommerce.controller;

import com.example.reactive_ecommerce.dto.Product;
import com.example.reactive_ecommerce.dto.Shipment;
import com.example.reactive_ecommerce.model.Cart;
import com.example.reactive_ecommerce.model.CartItem;
import com.example.reactive_ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @GetMapping("/{user-id}")
    public Mono<Cart> getCart(@PathVariable String userId) {
        return service.getCart(userId);
    }

    @PostMapping("/{user-id}/items")
    public Mono<Cart> addItem(@PathVariable String userId, @RequestBody CartItem item) {
        return service.addToCart(userId, item);
    }

    @GetMapping("/products")
    public Flux<Product> receiverAllProducts() {
        return service.receiverProducts();
    }

    @PostMapping("/purchase")
    public Mono<Shipment> purchaseCartItem( @RequestBody Cart cart) {
        return service.pay(cart);
    }

}
