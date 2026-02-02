package dev.engripaye.inventorymanagementsystem.service;

import dev.engripaye.inventorymanagementsystem.model.WareHouse;
import dev.engripaye.inventorymanagementsystem.repository.WareHouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WareHouseRepository wareHouseRepository;


    public WareHouse createWarehouse(WareHouse wareHouse){
        return wareHouseRepository.save(wareHouse);
    }

    public WareHouse getWarehouseByid(Long id){
        return wareHouseRepository.findById(id).orElseThrow(() -> ResourceNotFoundException("Warehouse not found"));
    }

    public List<WareHouse> getAllWarehouses(){
        return wareHouseRepository.findAll();
    }
}
