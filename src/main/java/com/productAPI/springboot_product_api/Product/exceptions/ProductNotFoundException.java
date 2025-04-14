package com.productAPI.springboot_product_api.Product.exceptions;

import java.util.UUID;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(UUID id) {
        super("Product not found with ID: " + id);
    }
}
