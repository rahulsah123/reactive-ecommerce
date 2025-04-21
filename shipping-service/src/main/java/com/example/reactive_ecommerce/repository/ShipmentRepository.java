package com.example.reactive_ecommerce.repository;

import com.example.reactive_ecommerce.model.Shipment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ShipmentRepository extends ReactiveMongoRepository<Shipment, String> {
}
