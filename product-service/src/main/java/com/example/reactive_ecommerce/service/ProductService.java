package com.example.reactive_ecommerce.service;

import com.example.reactive_ecommerce.model.Product;
import com.example.reactive_ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Flux<Product> getAll() {
        return repository.findAll();
    }

    public Mono<Product> create(Product product) {
        return repository.save(product);
    }

    public Mono<Product> updateStock(String id, int stock) {
        return repository.findById(id)
                .flatMap(p -> {
                    p.setStock(stock);
                    return repository.save(p);
                });
    }
}
