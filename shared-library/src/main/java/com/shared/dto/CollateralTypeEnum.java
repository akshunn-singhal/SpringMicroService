package com.shared.dto;


public enum CollateralTypeEnum {
    CASH("com.harman.collateral.processor.entity.CollateralCashDeposits"),
    REAL_ESTATE("com.harman.collateral.processor.entity.CollateralRealEstate");

    private final String className;

    private CollateralTypeEnum(String className) {
        this.className = className;
    }

    public Class<?> getClassName() {
        try {
            return Class.forName(this.className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
