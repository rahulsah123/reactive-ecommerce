package com.example.reactive_ecommerce.dto;

import com.example.reactive_ecommerce.model.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
public class Shipment {
    private String id;
    private String orderId;
    private String userId;
    private String address;
    private String status;
    private List<ProductItem> items;
}
