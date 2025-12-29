package com.inventory.inventoryservice.controller;

import com.inventory.inventoryservice.dto.ProductRequest;
import com.inventory.inventoryservice.dto.StockUpdateRequest;
import com.inventory.inventoryservice.entity.Product;
import com.inventory.inventoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    // ✅ ADD PRODUCT
    @PostMapping
    public Product add(@RequestBody ProductRequest request) {
        return productService.addProduct(request);
    }

    // ✅ GET ALL PRODUCTS
    @GetMapping
    public List<Product> all() {
        return productService.getAll();
    }

    // ✅ GET PRODUCT BY ID
    @GetMapping("/{id}")
    public Product find(@PathVariable Long id) {
        return productService.getById(id);
    }

    // ✅ DELETE PRODUCT
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // ✅ ADD STOCK (PUT)
    @PutMapping("/{id}")
    public Product addStock(
            @PathVariable Long id,
            @RequestBody StockUpdateRequest request
    ) {
        return productService.updateProduct(id, request.getQuantity());
    }
}
