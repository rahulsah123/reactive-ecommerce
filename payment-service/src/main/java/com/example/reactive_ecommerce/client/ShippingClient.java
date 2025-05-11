package com.example.reactive_ecommerce.client;

import com.example.reactive_ecommerce.constant.Constant;
import com.example.reactive_ecommerce.dto.Shipment;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ShippingClient {

    private final WebClient.Builder webClientBuilder;

    public ShippingClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<Shipment> createShipment(Shipment shipment) {
        return webClientBuilder.baseUrl(Constant.SHIPPING_BASE_URL).build()
                .post()
                .uri("/v1/create-shipment")
                .bodyValue(shipment)
                .retrieve()
                .bodyToMono(Shipment.class);
    }
}
