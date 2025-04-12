package com.productAPI.springboot_product_api.Product;

import com.productAPI.springboot_product_api.Product.model.Product;
import com.productAPI.springboot_product_api.Product.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void createProduct_ShouldReturnCreatedProductWithId() {
        Product product = new Product();
        product.setName("Hanzala's Product");
        product.setDescription("Applying Unit Testing");
        product.setPrice(100.0);
        product.setAvailable(true);

        Product createdProduct = productService.createProduct(product);

        assertNotNull(createdProduct.getId());
        assertEquals("Hanzala's Product", createdProduct.getName());
        assertEquals("Applying Unit Testing", createdProduct.getDescription());
        assertEquals(100.0, createdProduct.getPrice());
        assertTrue(createdProduct.getAvailable());
    }


    @Test
    void updateProduct_ShouldReturnUpdatedProduct() {
        UUID productId = UUID.randomUUID();
        Product product = new Product(productId,"PRODUCT IDENTIFIER", "Hanzala's Product","APPLYING UNIT TETSING",72.9,true);

        Product newCreatedProduct =  productService.createProduct(product);
        newCreatedProduct.setName("Hanzala's Product Updated");
        newCreatedProduct.setPrice(80.38);

        try {
            Product updatedProduct = productService.updateProduct(newCreatedProduct);
            assertEquals(newCreatedProduct.getName(),updatedProduct.getName());
            assertEquals(newCreatedProduct.getPrice(),updatedProduct.getPrice());
        } catch (Exception e){
            fail(e.getMessage());
        }
    }
}
