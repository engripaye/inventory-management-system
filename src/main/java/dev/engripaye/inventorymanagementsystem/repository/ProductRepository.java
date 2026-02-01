package dev.engripaye.inventorymanagementsystem.repository;

import dev.engripaye.inventorymanagementsystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySku(String sku);
}
