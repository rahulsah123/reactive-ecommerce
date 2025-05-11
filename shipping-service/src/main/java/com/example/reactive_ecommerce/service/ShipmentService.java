package com.example.reactive_ecommerce.service;

import com.example.reactive_ecommerce.model.Shipment;
import com.example.reactive_ecommerce.repository.ShipmentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ShipmentService {
    private final ShipmentRepository repository;

    public ShipmentService(ShipmentRepository repository) {
        this.repository = repository;
    }

    public Mono<Shipment> shipOrder(Shipment shipment) {
        shipment.setStatus("SHIPPED");
        shipment.setAddress("New Delhi, India");
        return repository.save(shipment);
    }
}
