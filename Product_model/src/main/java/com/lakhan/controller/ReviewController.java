package com.lakhan.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lakhan.model.Review;
import com.lakhan.service.ReviewService;


@RestController
@RequestMapping("/api/products/{productId}/reviews")
public class ReviewController {
	
	
	
	    private  ReviewService reviewService;

	    @Autowired
	    public ReviewController(ReviewService reviewService) {
	        this.reviewService = reviewService;
	    }

	    @PostMapping
	    public ResponseEntity<Review> addReview(@PathVariable Long productId, @RequestBody Review review) {
	        // Add review to the product with productId
	        Review newReview = reviewService.addReview(review);
	        return ResponseEntity.status(HttpStatus.CREATED).body(newReview);
	    }

	    @DeleteMapping("/{reviewId}")
	    public ResponseEntity<Void> deleteReview(@PathVariable Long productId, @PathVariable Long reviewId) {
	        // Delete review with reviewId from the product with productId
	        if (reviewService.deleteReview(reviewId)) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }



}
