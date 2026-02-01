package dev.engripaye.inventorymanagementsystem.repository;

import dev.engripaye.inventorymanagementsystem.model.Inventory;
import dev.engripaye.inventorymanagementsystem.model.Product;
import dev.engripaye.inventorymanagementsystem.model.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByProductAndWareHouse(Product product, WareHouse warehouse);
}
