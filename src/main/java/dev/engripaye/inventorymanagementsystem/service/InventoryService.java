package dev.engripaye.inventorymanagementsystem.service;

import dev.engripaye.inventorymanagementsystem.model.*;
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

        int newQty = switch (transactionType) {
            case INBOUND, TRANSFER_IN -> inventory.getQuantity() + quantity;
            case OUTBOUND, TRANSFER_OUT -> inventory.getQuantity() - quantity;
            case ADJUSTMENT -> quantity;


        };

        if(newQty < 0){
            throw new IllegalStateException("Insufficient Stock");
        }

        inventory.setQuantity(newQty);
        inventory.setLastUpdated(LocalDateTime.now());
        inventoryRepository.save(inventory);

        InventoryTransaction tx = new InventoryTransaction();
        tx.setProduct(product);
        tx.setWareHouse(wareHouse);
        tx.setTransactionType(transactionType);
        tx.setQuantity(quantity);
        tx.setReference(reference);

        transactionalRepository.save(tx);
    }

    private Inventory createInventory(Product product, WareHouse wareHouse){
        Inventory inv = new Inventory();
        inv.setProduct(product);
        inv.setWareHouse(wareHouse);
        inv.setQuantity(0);
        return inv;
    }
}
