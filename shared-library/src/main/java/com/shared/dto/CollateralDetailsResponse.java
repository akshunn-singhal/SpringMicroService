package com.shared.dto;

public record CollateralDetailsResponse(
        String type,
        String ownerName,
        String address,
        double currentValue,
        double interestRate,
        double depositAmount,
        double ratePerSQFT,
        String bankName
) {
}
