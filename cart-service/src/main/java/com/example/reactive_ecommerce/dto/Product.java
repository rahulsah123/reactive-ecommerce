package com.example.reactive_ecommerce.dto;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;
}
