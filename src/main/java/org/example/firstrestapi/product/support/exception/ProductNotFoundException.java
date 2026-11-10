package org.example.firstrestapi.product.support.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super(String.format("Product with %d not found", id));
        //please try not to use such form: "Product with "+ id +" not found")
        //because it's not good practice
        //the + operator should only be used for mathematical operations
    }
}
