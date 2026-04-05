package com.example.restapi.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository
        extends JpaRepository<Review, Long> {

    // Get all reviews for a specific product
    List<Review> findByProductId(Long productId);
}