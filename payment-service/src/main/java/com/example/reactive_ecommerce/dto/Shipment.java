package com.example.reactive_ecommerce.dto;

import lombok.Data;

import java.util.List;

@Data
public class Shipment {
    private String id;
    private String orderId;
    private String paymentId;
    private String userId;
    private String address;
    private String status;
    private double totalPrice;
    private List<ProductItem> items;
}
