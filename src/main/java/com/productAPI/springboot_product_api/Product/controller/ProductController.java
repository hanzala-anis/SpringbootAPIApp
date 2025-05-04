package com.productAPI.springboot_product_api. Product.controller;

import com.productAPI.springboot_product_api.Product.Constants;
import com.productAPI.springboot_product_api.Product.dto.ProductDTO;
import com.productAPI.springboot_product_api.Product.exceptions.ProductNotFoundException;
import com.productAPI.springboot_product_api.Product.service.ProductService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.productAPI.springboot_product_api.Product.mapper.ProductMapper;
import com.productAPI.springboot_product_api.Product.model.Product;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody @Valid ProductDTO dto) {
        Product created = service.createProduct(ProductMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductMapper.toDTO(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> get(@PathVariable UUID id) throws ProductNotFoundException {
      return ResponseEntity.ok(ProductMapper.toDTO(service.getProduct(id)));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok(service.getAllProducts().stream()
                .map(ProductMapper::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@RequestBody @Valid ProductDTO dto) throws ProductNotFoundException {
        Product updated = service.updateProduct(ProductMapper.toEntity(dto));
        return ResponseEntity.ok(ProductMapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) throws ProductNotFoundException {
            service.deleteProduct(id);
            return ResponseEntity.ok().body(Constants.PRODUCT_DELETED_SUCCESSFULLY.get());
    }
}
