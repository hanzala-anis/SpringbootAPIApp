package com.productAPI.springboot_product_api.Product.service;


import com.productAPI.springboot_product_api.Product.exceptions.ProductNotFoundException;
import com.productAPI.springboot_product_api.Product.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@Service
public class ProductService {
    private final ConcurrentMap<UUID, Product> productMap = new ConcurrentHashMap<>();
    private final static String SYSTEM_GENERATED_KEYWORD = "TEST7@@77373*272()833838";

    public Product createProduct(Product product) {
        UUID id = UUID.randomUUID();
        product .setProductSystemIdentifier(SYSTEM_GENERATED_KEYWORD+id.toString());
        product.setId(id);
        productMap.put(id, product);
        return product;
    }

    public Product getProduct(UUID id) throws ProductNotFoundException{
        return Optional.ofNullable(productMap.get(id))
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    public Product updateProduct(Product updatedProduct) throws ProductNotFoundException {
        UUID UUId = updatedProduct.getId();
        if (!productMap.containsKey(UUId)){
            throw new ProductNotFoundException(UUId);
        }
        productMap.put(UUId, updatedProduct);
        return updatedProduct;
    }

    public void deleteProduct(UUID id) throws ProductNotFoundException {
        if (!productMap.containsKey(id)) {
            throw new ProductNotFoundException(id);
        }
        productMap.remove(id);
    }
}
