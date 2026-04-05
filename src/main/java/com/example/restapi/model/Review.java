package com.example.restapi.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema= "test", name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String reviewerName;

    @Column(nullable = false, length = 1000)
    private String comment;

    @Column(nullable = false)
    private int rating; // 1 to 5

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private Product product;

    public Review() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getReviewerName() { return reviewerName; }
    public void setReviewerName(String n) { this.reviewerName = n; }

    public String getComment() { return comment; }
    public void setComment(String c) { this.comment = c; }

    public int getRating() { return rating; }
    public void setRating(int r) { this.rating = r; }

    public Product getProduct() { return product; }
    public void setProduct(Product p) { this.product = p; }
}