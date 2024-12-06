package com.shared.dto;

import java.time.LocalDateTime;
import java.util.List;

public record CollateralRequest(long loanId,
                                long collateralId,
                                double collateralValue,
                                LocalDateTime pledgedDate,
                                long customerId,
                                List<CollateralDetails> collateralDetails) {
}
