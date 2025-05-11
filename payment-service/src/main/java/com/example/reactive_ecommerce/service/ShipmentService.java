package com.example.reactive_ecommerce.service;

import com.example.reactive_ecommerce.client.ShippingClient;
import com.example.reactive_ecommerce.dto.Shipment;
import com.example.reactive_ecommerce.model.Payment;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ShipmentService {
    private final ShippingClient shippingClient;

    public ShipmentService(ShippingClient shippingClient) {
        this.shippingClient = shippingClient;
    }

    public Mono<Shipment> createShipment(Payment payment) {
        Shipment shipment = createShippingOrder(payment);
       return shippingClient.createShipment(shipment);
    }

    private Shipment createShippingOrder(Payment payment) {
        Shipment shipment = new Shipment();
        shipment.setId(UUID.randomUUID().toString());
        shipment.setOrderId(payment.getOrderId());
        shipment.setPaymentId(payment.getId());
        shipment.setUserId(payment.getUserId());
        shipment.setTotalPrice(payment.getTotalPrice());
        shipment.setItems(payment.getItems());
        return shipment;
    }
}
