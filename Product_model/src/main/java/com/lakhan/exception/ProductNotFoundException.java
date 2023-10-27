package com.lakhan.exception;

public class ProductNotFoundException extends CustomException{
	
	public ProductNotFoundException(Long id) {
        super("Product with ID " + id + " not found");
    }

}
