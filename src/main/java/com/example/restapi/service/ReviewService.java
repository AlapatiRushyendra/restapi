package com.example.restapi.service;

import com.example.restapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    // GET all reviews for a product
    public List<Review> getByProductId(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    // GET one review by ID
    public Optional<Review> getById(Long id) {
        return reviewRepository.findById(id);
    }

    // POST - create review for a product
    public Optional<Review> create(Long productId,
                                     Review review) {
        return productRepository.findById(productId)
            .map(product -> {
                review.setProduct(product);
                return reviewRepository.save(review);
            });
    }

    // PUT - update a review
    public Optional<Review> update(Long id,
                                     Review updated) {
        return reviewRepository.findById(id)
            .map(existing -> {
                existing.setReviewerName(
                    updated.getReviewerName());
                existing.setComment(updated.getComment());
                existing.setRating(updated.getRating());
                return reviewRepository.save(existing);
            });
    }

    // DELETE - remove a review
    public boolean delete(Long id) {
        if (!reviewRepository.existsById(id)) {
            return false;
        }
        reviewRepository.deleteById(id);
        return true;
    }
}
