package dev.engripaye.inventorymanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "warehouse")
@Getter
@Setter
public class WareHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private String name;
    private String location;

    @CreationTimestamp
    private LocalDateTime createdAt;



}
