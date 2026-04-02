package com.example.restapi.service;

import com.example.restapi.model.Product;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {

    private final Map<Long, Product> productStore =
        new HashMap<>();
    private long idCounter = 1;

    public ProductService() {
        save(new Product(null, "Laptop",
            "High-performance laptop", 999.99));
        save(new Product(null, "Phone",
            "Latest smartphone", 699.99));
        save(new Product(null, "Headphones",
            "Noise-cancelling", 199.99));
    }

    public List<Product> getAll() {
        return new ArrayList<>(productStore.values());
    }

    public Optional<Product> getById(Long id) {
        return Optional.ofNullable(productStore.get(id));
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(idCounter++);
        }
        productStore.put(product.getId(), product);
        return product;
    }

    public Optional<Product> update(Long id, Product p) {
        if (!productStore.containsKey(id)) {
            return Optional.empty();
        }
        p.setId(id);
        productStore.put(id, p);
        return Optional.of(p);
    }

    public boolean delete(Long id) {
        return productStore.remove(id) != null;
    }
}