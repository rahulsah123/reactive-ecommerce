package com.example.reactive_ecommerce.controller;

import com.example.reactive_ecommerce.model.Product;
import com.example.reactive_ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Product> all() {
        return service.getAll();
    }

    @PostMapping
    public Mono<Product> create(@RequestBody Product product) {
        return service.create(product);
    }

    @PutMapping("/{id}/stock")
    public Mono<Product> updateStock(@PathVariable String id, @RequestBody int stock) {
        return service.updateStock(id, stock);
    }
}
