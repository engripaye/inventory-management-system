package dev.engripaye.inventorymanagementsystem.service;

import dev.engripaye.inventorymanagementsystem.model.Inventory;
import dev.engripaye.inventorymanagementsystem.model.Product;
import dev.engripaye.inventorymanagementsystem.model.TransactionType;
import dev.engripaye.inventorymanagementsystem.model.WareHouse;
import dev.engripaye.inventorymanagementsystem.repository.InventoryRepository;
import dev.engripaye.inventorymanagementsystem.repository.InventoryTransactionalRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static dev.engripaye.inventorymanagementsystem.model.TransactionType.*;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryTransactionalRepository transactionalRepository;

    public void processTransaction(
            Product product,
            WareHouse wareHouse,
            TransactionType transactionType,
            int quantity,
            String reference
    ){
        Inventory inventory = inventoryRepository.findByProductAndWareHouse(
                product, wareHouse
        ).orElseGet(() -> createInventory(product, wareHouse));

        int newQty = switch (type) {
            case INBOUND, TRANSFER_IN -> inventory.getQuantity() + quantity;
            case OUTBOUND, TRANSFER_OUT -> inventory.getQuantity() - quantity;
            case ADJUSTMENT -> quantity;


        };

        if(newQty < 0){
            throw new IllegalStateException("Insufficient Stock");
        }

        inventory.setQuantity(newQty);
        inventory.SetLastUpdated(LocalDateTime.now());
    }

}
