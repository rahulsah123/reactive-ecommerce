package com.example.reactive_ecommerce.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "payments")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    private String id;
    private String userId;
    private String orderId;
    private double amount;
    private String status;
}
