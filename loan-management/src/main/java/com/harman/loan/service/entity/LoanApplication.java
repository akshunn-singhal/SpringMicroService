package com.harman.loan.service.entity;

import com.harman.loan.service.dto.LoanStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "loan_application")
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @OneToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    private double loanAmount;

    private double tenure;

    private long collateralId;

    private LoanStatus status;
}

