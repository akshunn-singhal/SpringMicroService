package com.harman.loan.service.repository;

import com.harman.loan.service.dto.LoanStatus;
import com.harman.loan.service.entity.LoanApplication;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanManagementRepository extends JpaRepository<LoanApplication, Long> {
    @Query("UPDATE LoanApplication la SET la.status=:status WHERE la.applicationId=:applicationId")
    @Transactional
    @Modifying
    int updateApplicationStatus(long applicationId, LoanStatus status);

}
