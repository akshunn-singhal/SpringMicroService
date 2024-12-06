package com.shared.dto;

import java.util.List;

public record CollateralResponse(long collateralId, List<CollateralDetailsResponse> collaterals) {
}