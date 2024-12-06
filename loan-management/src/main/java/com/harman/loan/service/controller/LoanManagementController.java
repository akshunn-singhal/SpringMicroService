package com.harman.loan.service.controller;

import com.harman.loan.service.dto.LoanApplicationRequest;
import com.harman.loan.service.dto.LoanStatus;
import com.harman.loan.service.service.LoanManagementService;
import com.shared.dto.CollateralDetailsResponse;
import com.shared.dto.CollateralRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/loan")
@RequiredArgsConstructor
@Slf4j
public class LoanManagementController {

    private final LoanManagementService service;

    @GetMapping("/getLoanDetails")
    public ResponseEntity<List<CollateralDetailsResponse>> getLoanDetails(@RequestParam long loanId, @RequestParam long customerId) {
        List<CollateralDetailsResponse> loanDetails = service.getLoanDetails(loanId, customerId);
        return ResponseEntity.ok(loanDetails);
    }

    @PostMapping("/saveCollaterals")
    public ResponseEntity<CompletableFuture<String>> saveCollaterals(@RequestBody CollateralRequest request) {
        CompletableFuture<String> message = service.saveCollaterals(request);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/applyLoan")
    public ResponseEntity<String> applyLoan(@RequestBody LoanApplicationRequest application) {
        long id = service.saveLoanApplication(application);
        return ResponseEntity.ok("Success");
    }


    @GetMapping("/getLoanApplicationStatus/{applicationId}")
    public ResponseEntity<LoanApplicationRequest> getApplicationLoanStatus(@PathVariable long applicationId){
        LoanApplicationRequest application = service.getApplicationLoanStatus(applicationId);
        return ResponseEntity.ok(application);
    }

    @PutMapping("/updateStatus/{applicationId}")
    public ResponseEntity<String> getApplicationLoanStatus(@PathVariable long applicationId , @RequestParam LoanStatus status){
        int success = service.updateApplicationStatus(applicationId, status);
        return ResponseEntity.ok(success > 0 ? "Success": "Failure");
    }

}
