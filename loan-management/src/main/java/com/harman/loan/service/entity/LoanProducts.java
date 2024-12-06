package com.harman.loan.service.entity;

import com.shared.dto.CollateralTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "loan_products")
@NoArgsConstructor
@AllArgsConstructor
public class LoanProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanProductId;

    private double tenure;

    private double maxEligibleLoan;

    private double interest;

    private CollateralTypeEnum type;
}
