package com.productAPI.springboot_product_api.Product;

public enum Constants {
    PRODUCT_DELETED_SUCCESSFULLY("Product Deleted Successfully.");

    private final String message;

    Constants(String message){
        this.message = message;
    }

    public String get() {
        return message;
    }
}
