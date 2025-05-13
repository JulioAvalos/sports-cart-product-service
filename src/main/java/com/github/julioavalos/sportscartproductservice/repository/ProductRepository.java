package com.github.julioavalos.sportscartproductservice.repository;

import com.github.julioavalos.sportscartproductservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
}
