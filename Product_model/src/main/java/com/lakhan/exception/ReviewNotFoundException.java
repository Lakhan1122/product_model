package com.lakhan.exception;

public class ReviewNotFoundException extends CustomException {
	
    public ReviewNotFoundException(Long id) {
        super("Review with ID " + id + " not found");
    }
}
