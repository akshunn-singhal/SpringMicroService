package com.harman.collateral.processor.exception;

import com.shared.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .contentType(MediaType.APPLICATION_JSON).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(CollateralNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCollateralException(CollateralNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .contentType(MediaType.APPLICATION_JSON).body(new ErrorResponse(ex.getErrorMessage()));
    }
}
