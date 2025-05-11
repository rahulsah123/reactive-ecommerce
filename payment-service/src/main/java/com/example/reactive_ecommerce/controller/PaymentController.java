package com.example.reactive_ecommerce.controller;

import com.example.reactive_ecommerce.dto.Shipment;
import com.example.reactive_ecommerce.manager.OrderManagement;
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
    private final OrderManagement orderManagement;

    public PaymentController(OrderManagement orderManagement) {
        this.orderManagement = orderManagement;
    }

    @PostMapping
    public Mono<Shipment> pay(@RequestBody Payment payment) {
        return orderManagement.payBook(payment);
    }
}
