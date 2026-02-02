package dev.engripaye.inventorymanagementsystem.dto;

import dev.engripaye.inventorymanagementsystem.model.TransactionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryTransactionRequest {

    @NotNull
    private Long productId;

    @NotNull
    private Long warehouseId;

    @NotNull
    private TransactionType transactionType;

    @Min(1)
    private int quantity;

    private String reference;
}
