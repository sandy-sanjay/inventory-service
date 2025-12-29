package com.inventory.inventoryservice.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private double price;
    private int quantity;
    private String imageUrl;
}
