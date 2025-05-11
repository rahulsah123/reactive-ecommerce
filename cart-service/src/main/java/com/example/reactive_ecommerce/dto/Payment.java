package com.example.reactive_ecommerce.dto;


import lombok.Data;

@Data
public class Payment {
    private String id;
    private String userId;
    private String orderId;
    private double amount;
    private String status;
}
