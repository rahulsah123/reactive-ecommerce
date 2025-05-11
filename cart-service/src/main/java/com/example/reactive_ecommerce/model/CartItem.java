package com.example.reactive_ecommerce.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private String id;
    private String name;
    private int quantity;
    private double price;
}
