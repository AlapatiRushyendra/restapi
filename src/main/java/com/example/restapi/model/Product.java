package com.example.restapi.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;

@Entity
@Table(schema = "test",name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private double price;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();


    public Product() {}

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> r) { this.reviews = r; }
}