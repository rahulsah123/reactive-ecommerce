package com.example.reactive_ecommerce.service;

import com.example.reactive_ecommerce.model.Payment;
import com.example.reactive_ecommerce.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PaymentService {
    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public Mono<Payment> processPayment(Payment payment) {
        payment.setStatus("COMPLETED");
        return repository.save(payment);
    }
}
