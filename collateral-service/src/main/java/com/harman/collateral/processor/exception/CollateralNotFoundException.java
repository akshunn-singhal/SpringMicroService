package com.harman.collateral.processor.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CollateralNotFoundException extends RuntimeException {
    private String errorMessage;
}
