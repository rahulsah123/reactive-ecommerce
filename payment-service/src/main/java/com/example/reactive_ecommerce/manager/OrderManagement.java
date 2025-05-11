package com.example.reactive_ecommerce.manager;

import com.example.reactive_ecommerce.dto.Shipment;
import com.example.reactive_ecommerce.model.Payment;
import com.example.reactive_ecommerce.service.PaymentService;
import com.example.reactive_ecommerce.service.ShipmentService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class OrderManagement {

    private final ShipmentService shipmentService;
    private final PaymentService paymentService;

    public OrderManagement(ShipmentService shipmentService, PaymentService paymentService) {
        this.shipmentService = shipmentService;
        this.paymentService = paymentService;
    }

    public Mono<Shipment> payBook(Payment payment){
        Mono<Payment> paymentMono = paymentService.processPayment(payment);
        return shipmentService.createShipment(Objects.requireNonNull(paymentMono.block()));
    }
}
