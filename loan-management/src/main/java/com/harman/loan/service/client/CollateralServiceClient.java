package com.harman.loan.service.client;
import com.shared.dto.CollateralDetailsResponse;
import com.shared.dto.CollateralResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "COLLATERAL-MANAGEMENT")
public interface CollateralServiceClient {

    @GetMapping("/api/collateral/getCollaterals")
    List<CollateralDetailsResponse> getCollaterals(@RequestParam long loanId, @RequestParam long customerId);
}
