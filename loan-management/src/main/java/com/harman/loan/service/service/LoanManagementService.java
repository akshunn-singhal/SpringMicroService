package com.harman.loan.service.service;

import com.harman.loan.service.client.CollateralServiceClient;
import com.harman.loan.service.dto.LoanApplicationRequest;
import com.harman.loan.service.dto.LoanStatus;
import com.harman.loan.service.kafka.producer.CollateralProducer;
import com.shared.dto.CollateralDetailsResponse;
import com.shared.dto.CollateralResponse;
import com.shared.dto.CollateralRequest;
import com.harman.loan.service.entity.LoanApplication;
import com.harman.loan.service.exception.ApplicationNotFoundException;
import com.harman.loan.service.repository.LoanManagementRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class LoanManagementService {

    private final LoanManagementRepository repository;

    private final CollateralServiceClient client;

    private final ModelMapper mapper;
    private final CollateralProducer producer;

    public List<CollateralDetailsResponse> getLoanDetails(long loanId, long customerId) {
        return client.getCollaterals(loanId, customerId);
    }

    public CompletableFuture<String> saveCollaterals(CollateralRequest request) {
        return producer.sendMessage(request).thenApply(result ->{
            return (result != null) ?"Successfully placed" : "Error Occcured";
        });
    }

    public LoanApplicationRequest getApplicationLoanStatus(long applicationId) {
        Optional<LoanApplication> application = repository.findById(applicationId);
        if(application.isEmpty()) {
            throw new ApplicationNotFoundException("No application with such id: "+applicationId);
        }
        LoanApplication app = application.get();
        LoanApplicationRequest request = new LoanApplicationRequest(
                app.getCustomer().getCustomerId(),
                app.getLoanAmount(),
                app.getTenure(),
                app.getCollateralId(),
                app.getStatus()
        );
        return request;
    }

    public int updateApplicationStatus(long applicationId, LoanStatus status) {
        return repository.updateApplicationStatus(applicationId, status);
    }

    public long saveLoanApplication(LoanApplicationRequest application) {
        LoanApplication app = mapper.map(application, LoanApplication.class);
        app = repository.save(app);
        return app.getApplicationId();
    }
}
