package dev.engripaye.inventorymanagementsystem.service;

import dev.engripaye.inventorymanagementsystem.repository.InventoryRepository;
import dev.engripaye.inventorymanagementsystem.repository.InventoryTransactionalRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryTransactionalRepository transactionalRepository;


}
