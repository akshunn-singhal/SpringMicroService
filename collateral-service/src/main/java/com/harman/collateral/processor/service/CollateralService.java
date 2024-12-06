package com.harman.collateral.processor.service;

import com.harman.collateral.processor.entity.CollateralLoan;
import com.harman.collateral.processor.entity.CollateralTypes;
import com.harman.collateral.processor.repository.CollateralLoanRepository;
import com.harman.collateral.processor.repository.CollateralTypeRepository;
import com.shared.dto.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CollateralService {

    private final CollateralLoanRepository loanRepository;
    private final CollateralTypeRepository typeRepository;
    private final ModelMapper mapper;

    @Transactional
    public long saveCollateral(CollateralRequest request) {
        CollateralLoan loan = mapper.map(request, CollateralLoan.class);
        loan.setCollateralId(null);
        List<CollateralDetails> collateralDetails = request.collateralDetails();
        List<CollateralTypes> updatedList = collateralDetails.stream().map(obj -> {
            CollateralTypes collateral = (CollateralTypes) mapper.map(obj, obj.type().getClassName());
            collateral.setCollateralTypeId(null);
            collateral.setLoan(loan);
            return collateral;
        }).toList();
        loan.setCollaterals(updatedList);
        CollateralLoan obj = loanRepository.save(loan);
        return obj.getCollateralId();
    }

    public List<CollateralDetailsResponse> getCollateral(long loanId, long customerId) {
        List<CollateralDetailsResponse> response = loanRepository.findByLoanIdAndCustomerId(loanId, customerId);
        log.info("CollateralDetailsResponse:{}",response);
        return response;
    }
}