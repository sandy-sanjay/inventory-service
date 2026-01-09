// dto/StockUpdateRequest.java
package com.inventory.inventoryservice.dto;

import lombok.Data;

@Data
public class StockUpdateRequest {
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
