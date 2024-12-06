package com.shared.dto;

public record CollateralDetails(
        CollateralTypeEnum type,
        String ownerName,
        String address,
        double currentValue,
        double interestRate,
        double depositAmount,
        double ratePerSQFT,
        String bankName
) {
}
