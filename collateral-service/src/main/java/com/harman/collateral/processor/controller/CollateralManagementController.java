package com.harman.collateral.processor.controller;

import com.harman.collateral.processor.entity.CollateralLoan;
import com.harman.collateral.processor.exception.CollateralNotFoundException;
import com.harman.collateral.processor.service.CollateralService;
import com.shared.dto.CollateralDetailsResponse;
import com.shared.dto.CollateralRequest;
import com.shared.dto.CollateralResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collateral")
@RequiredArgsConstructor
@Slf4j
public class CollateralManagementController {

    private final CollateralService service;

    @GetMapping("/getCollaterals")
    public ResponseEntity<List<CollateralDetailsResponse>> getCollaterals(@RequestParam long loanId, @RequestParam long customerId) {
        List<CollateralDetailsResponse> response = service.getCollateral(loanId, customerId);
        if(response.size()==0) {
            throw new CollateralNotFoundException("No Collateral found");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/saveCollaterals")
    public ResponseEntity<Long> saveCollateral(@RequestBody CollateralRequest request) {
        long id = service.saveCollateral(request);
        return ResponseEntity.ok(id);
    }

}
