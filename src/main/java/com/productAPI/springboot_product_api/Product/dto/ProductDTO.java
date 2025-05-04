package com.productAPI.springboot_product_api.Product.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private UUID id;

    @NotEmpty(message =  "Product name cannot be null")
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
    private String name;

    @NotEmpty (message = "Description cannot be null")
    private String description;

    @NotNull (message = "Price cannot be null")
    @Min(value = 0, message = "Price must be a positive value")
    private Double price;

    @NotNull(message = "Availability cannot be null")
    private Boolean available;
}
