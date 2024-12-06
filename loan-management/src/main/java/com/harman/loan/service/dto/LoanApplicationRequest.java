package com.harman.loan.service.dto;

public record LoanApplicationRequest(
        long customerId,
        double loanAmount,
        double tenure,
        long collateralId,
        LoanStatus status
) {
}
