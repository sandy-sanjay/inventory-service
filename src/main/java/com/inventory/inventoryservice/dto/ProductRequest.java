package com.inventory.inventoryservice.dto;

public class ProductRequest {

    private String name;
    private double price;
    private int quantity;
    private String imageUrl;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
