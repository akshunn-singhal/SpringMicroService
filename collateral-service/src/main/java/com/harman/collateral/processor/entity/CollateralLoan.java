package com.harman.collateral.processor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "collateral_loan")
@NoArgsConstructor
@AllArgsConstructor

public class CollateralLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collateralId;

    private long loanId;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CollateralTypes> collaterals;

    private double collateralValue;

    private LocalDateTime pledgedDate;

    private long customerId;
}
