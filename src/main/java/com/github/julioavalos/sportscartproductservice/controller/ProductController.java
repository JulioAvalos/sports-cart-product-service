package com.github.julioavalos.sportscartproductservice.controller;

import com.github.julioavalos.sportscartproductservice.model.Product;
import com.github.julioavalos.sportscartproductservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository repo;

    @GetMapping
    public List<Product> findAll() {
        return repo.findAll();
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String q) {
        return repo.findByNameContainingIgnoreCase(q);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
