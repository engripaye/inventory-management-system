package dev.engripaye.inventorymanagementsystem.repository;

import dev.engripaye.inventorymanagementsystem.model.InventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryTransferRepository extends JpaRepository<InventoryTransaction, Long> {
}
