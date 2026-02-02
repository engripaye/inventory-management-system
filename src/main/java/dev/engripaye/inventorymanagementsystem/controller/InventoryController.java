package dev.engripaye.inventorymanagementsystem.controller;

import dev.engripaye.inventorymanagementsystem.service.InventoryService;
import dev.engripaye.inventorymanagementsystem.service.ProductService;
import dev.engripaye.inventorymanagementsystem.service.WarehouseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    private final ProductService productService;
    private final WarehouseService warehouseService;

    @PostMapping("/transaction")
    public ResponseEntity<String> processInventoryTransaction(
            @Valid
    )
}


