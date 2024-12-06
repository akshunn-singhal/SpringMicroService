package com.harman.loan.service.dto;

public record LoanResponse(long loanProductId,
                           double sanctionedLoanAmount,
                           double tenure,
                           double interest,
                           long collateralId
) {
}
