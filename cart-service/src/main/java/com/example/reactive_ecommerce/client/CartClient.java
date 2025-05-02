package com.example.reactive_ecommerce.client;

import com.example.reactive_ecommerce.dto.Product;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CartClient {

    private final WebClient.Builder webClientBuilder;

    public CartClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Flux<Product> receiverProduct(Integer productId) {
        return webClientBuilder.baseUrl("http://localhost:8081").build()
                .get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class);
    }
}
