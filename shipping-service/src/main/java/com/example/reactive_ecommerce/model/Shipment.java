package com.example.reactive_ecommerce.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "shipments")
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    @Id
    private String id;
    private String orderId;
    private String userId;
    private String address;
    private String status;
    private double totalPrice;
    private List<ProductItem> items;
}
