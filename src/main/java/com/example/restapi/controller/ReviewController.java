package com.example.restapi.controller;

import com.example.restapi.model.Review;
import com.example.restapi.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products/{productId}/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // GET all reviews for a product
    @GetMapping
    public ResponseEntity<List<Review>> getAll(
            @PathVariable Long productId) {
        return ResponseEntity.ok(
            reviewService.getByProductId(productId));
    }

    // GET one review
    @GetMapping("/{id}")
    public ResponseEntity<Review> getById(
            @PathVariable Long id) {
        return reviewService.getById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // POST - add review to product
    @PostMapping
    public ResponseEntity<Review> create(
            @PathVariable Long productId,
            @RequestBody Review review) {
        return reviewService.create(productId, review)
            .map(r -> ResponseEntity
                .status(HttpStatus.CREATED).body(r))
            .orElse(ResponseEntity.notFound().build());
    }

    // PUT - update review
    @PutMapping("/{id}")
    public ResponseEntity<Review> update(
            @PathVariable Long id,
            @RequestBody Review review) {
        return reviewService.update(id, review)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - remove review
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {
        if (reviewService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
