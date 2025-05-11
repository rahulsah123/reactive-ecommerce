package com.example.reactive_ecommerce.dto;

import lombok.Data;

@Data
public class ProductItem {
    private String id;
    private String name;
    private int quantity;
    private double price;
}
