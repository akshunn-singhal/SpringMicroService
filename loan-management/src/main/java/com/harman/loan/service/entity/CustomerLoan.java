package com.harman.loan.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "customer_loan")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "loanProductId")
    private LoanProducts productId;

    private double loanPrinciple;

    private double tenure;

    private double interest;

    private double emi;

    private long collateralId;
}
