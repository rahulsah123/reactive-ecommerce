package com.example.reactive_ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ProductItem {
    private String id;
    private String name;
    private int quantity;
}
