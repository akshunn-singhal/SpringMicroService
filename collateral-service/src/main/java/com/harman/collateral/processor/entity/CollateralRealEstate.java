package com.harman.collateral.processor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "collateral_realEstate")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "collateralTypeId")
public class CollateralRealEstate extends CollateralTypes{
    private double ratePerSQFT;
}
