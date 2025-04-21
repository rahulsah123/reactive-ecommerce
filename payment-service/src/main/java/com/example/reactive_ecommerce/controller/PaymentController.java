package com.example.reactive_ecommerce.controller;

import com.example.reactive_ecommerce.model.Payment;
import com.example.reactive_ecommerce.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<Payment> pay(@RequestBody Payment payment) {
        return service.processPayment(payment);
    }
}
