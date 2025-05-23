package com.example.reactive_ecommerce.dto;


import lombok.Data;

import java.util.List;

@Data
public class Payment {
    private String id;
    private String userId;
    private String orderId;
    private String status;
    private double totalPrice;
    private List<ProductItem> items;
}
