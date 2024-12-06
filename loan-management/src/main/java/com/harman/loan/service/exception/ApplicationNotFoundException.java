package com.harman.loan.service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class ApplicationNotFoundException extends RuntimeException {
    private String errorMessage;
}
