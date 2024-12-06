package com.harman.collateral.processor.repository;

import com.harman.collateral.processor.entity.CollateralTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollateralTypeRepository extends JpaRepository<CollateralTypes, Long> {
}
