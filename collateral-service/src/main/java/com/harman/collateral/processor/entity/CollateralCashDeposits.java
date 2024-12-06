package com.harman.collateral.processor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "collateral_cashDeposits")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "collateralTypeId")
public class CollateralCashDeposits extends CollateralTypes {

    private double ratePerSQFT;

    private String bankName;

    private double interestRate;

    private double depositAmount;
}
