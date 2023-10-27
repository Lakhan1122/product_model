package com.lakhan.service;



//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakhan.model.Review;

import com.lakhan.repository.ReviewRepository;

@Service
public class ReviewService {

	
	
	private  ReviewRepository reviewRepository;
	

	@Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public boolean deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }
//
//	public List<Review> getReviewsForProduct(Long productId) {
//		// TODO Auto-generated method stub
//        return reviewRepository.findByProductId(productId);
//
//	}


	
}
