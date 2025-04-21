package com.example.reactive_ecommerce.repository;

import com.example.reactive_ecommerce.model.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {
}
