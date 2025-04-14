package com.productAPI.springboot_product_api.Product.mapper;

import com.productAPI.springboot_product_api.Product.dto.ProductDTO;
import com.productAPI.springboot_product_api.Product.model.Product;

import java.util.UUID;

public class ProductMapper {

    public static Product toEntity(ProductDTO dto) {
        if (dto == null) return null;

        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .available(dto.getAvailable())
                .build();
    }

    public static ProductDTO toDTO(Product product) {
        if (product == null) return null;

        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .available(product.getAvailable())
                .build();
    }
}
