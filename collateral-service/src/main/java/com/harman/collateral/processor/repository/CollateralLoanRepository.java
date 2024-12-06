package com.harman.collateral.processor.repository;

import com.harman.collateral.processor.entity.CollateralLoan;
import com.shared.dto.CollateralDetailsResponse;
import com.shared.dto.CollateralResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollateralLoanRepository extends JpaRepository<CollateralLoan, Long> {
    @Query("""
                         SELECT new com.shared.dto.CollateralDetailsResponse(
                         CASE 
                             WHEN cashDeposit.collateralTypeId IS NOT NULL THEN 'CASH'
                             WHEN realEstate.collateralTypeId IS NOT NULL THEN 'REAL_ESTATE'
                             ELSE 'CASH' 
                         END,
                         ctypes.ownerDetails,
                         ctypes.address,
                         COALESCE(ctypes.currentValue,0),
                         COALESCE(cashDeposit.interestRate,0),
                         COALESCE(cashDeposit.depositAmount,0),
                         0,
                         cashDeposit.bankName
                         ) 
                        FROM CollateralTypes ctypes
                        LEFT JOIN CollateralCashDeposits cashDeposit ON ctypes.collateralTypeId = cashDeposit.collateralTypeId
                        LEFT JOIN CollateralRealEstate realEstate ON ctypes.collateralTypeId = realEstate.collateralTypeId
                        WHERE ctypes.loan.collateralId = 
                        (SELECT loan.collateralId FROM CollateralLoan loan WHERE loan.loanId = :loanId AND loan.customerId = :customerId)""")
    List<CollateralDetailsResponse> findByLoanIdAndCustomerId(long loanId, long customerId);
}
