package com.example.reactive_ecommerce.model;

import com.example.reactive_ecommerce.dto.ProductItem;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "payments")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    private String id;
    private String userId;
    private String orderId;
    private double totalPrice;
    private String status;
    private List<ProductItem> items;
}
