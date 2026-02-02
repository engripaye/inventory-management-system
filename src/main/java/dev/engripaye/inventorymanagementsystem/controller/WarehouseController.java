package dev.engripaye.inventorymanagementsystem.controller;

import dev.engripaye.inventorymanagementsystem.model.WareHouse;
import dev.engripaye.inventorymanagementsystem.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @PostMapping
    public ResponseEntity<WareHouse> createWarehouse(
            @RequestBody WareHouse wareHouse
    ){
        return ResponseEntity.ok(warehouseService.createWarehouse(wareHouse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WareHouse> getWarehouseById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(warehouseService.getWarehouseByid(id));
    }

    @GetMapping
    public ResponseEntity<List<WareHouse>> getAllWarehouse() {
        return ResponseEntity.ok(warehouseService.getAllWarehouses());
    }
}
