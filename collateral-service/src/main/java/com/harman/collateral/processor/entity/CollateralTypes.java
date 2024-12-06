package com.harman.collateral.processor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public abstract class CollateralTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collateralTypeId;

    @ManyToOne
    @JoinColumn(name = "collateralId", nullable = false)
    private CollateralLoan loan;

    private String ownerDetails;

    private String address;

    private double currentValue;
}
