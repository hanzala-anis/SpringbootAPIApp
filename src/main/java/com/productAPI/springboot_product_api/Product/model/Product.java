package com.productAPI.springboot_product_api.Product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private UUID id;
    private String productSystemIdentifier;
    private String name;
    private String description;
    private Double price;
    private Boolean available;
}
