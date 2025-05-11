package com.example.reactive_ecommerce.client;

import com.example.reactive_ecommerce.constant.Constant;
import com.example.reactive_ecommerce.dto.Payment;
import com.example.reactive_ecommerce.dto.Product;
import com.example.reactive_ecommerce.dto.Shipment;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CartClient {

    private final WebClient.Builder webClientBuilder;

    public CartClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Flux<Product> receiverProducts() {
        return webClientBuilder.baseUrl(Constant.PRODUCT_BASE_URL).build()
                .get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class);
    }

    public Mono<Shipment> createShipment(Shipment shipment) {
        return webClientBuilder.baseUrl(Constant.SHIPPING_BASE_URL).build()
                .post()
                .uri("/v1/create-shipment")
                .bodyValue(shipment)
                .retrieve()
                .bodyToMono(Shipment.class);
    }

    public Mono<Payment> pay(Payment payment) {
        return webClientBuilder.baseUrl(Constant.PAYMENT_BASE_URL).build()
                .post()
                .uri("/payments")
                .bodyValue(payment)
                .retrieve()
                .bodyToMono(Payment.class);
    }
}
