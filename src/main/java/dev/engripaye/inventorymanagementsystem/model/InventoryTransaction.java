package dev.engripaye.inventorymanagementsystem.model;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory_transactions")
@Getter
@Setter
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private WareHouse wareHouse;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private int quantity;
    private String reference;
    private String remarks;

    @CreationTimestamp
    private LocalDateTime localDateTime;


}

