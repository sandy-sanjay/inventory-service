package com.inventory.inventoryservice.service;

import com.inventory.inventoryservice.dto.ProductRequest;
import com.inventory.inventoryservice.entity.Product;
import com.inventory.inventoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // ✅ CREATE PRODUCT
    public Product addProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setImageUrl(request.getImageUrl());
        return productRepository.save(product);
    }

    // ✅ GET ALL
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    // ✅ GET BY ID
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // ✅ DELETE
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // ✅ ADD STOCK (IMPORTANT)
    public Product updateProduct(Long id, int qty) {
        if (qty <= 0) {
            throw new RuntimeException("Quantity must be greater than zero");
        }

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setQuantity(product.getQuantity() + qty);
        return productRepository.save(product);
    }
}
