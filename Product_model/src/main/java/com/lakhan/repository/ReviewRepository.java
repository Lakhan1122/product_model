package com.lakhan.repository;


//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lakhan.model.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

	Review save(Review review);

	

}
