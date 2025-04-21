package com.example.reactive_ecommerce.controller;

import com.example.reactive_ecommerce.model.Shipment;
import com.example.reactive_ecommerce.service.ShipmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    private final ShipmentService service;

    public ShipmentController(ShipmentService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<Shipment> createShipment(@RequestBody Shipment shipment) {
        return service.shipOrder(shipment);
    }
}
