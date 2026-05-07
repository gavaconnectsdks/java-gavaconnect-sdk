package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.FetchTaxpayerObligationRequest;
import io.github.gavaconnectsdks.dtos.responses.FetchTaxpayerObligationresponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class TaxPayerObligationService extends IService {
    public TaxPayerObligationService(GavaConfig config,Auth auth){
        super(config, auth);
        this.endpoint="/dtd/checker/v1/obligation";
    }

    public FetchTaxpayerObligationresponse request(FetchTaxpayerObligationRequest request) throws IllegalAccessException,IOException,InterruptedException {
        try {
            ValidatorEngine.validate(request);
            FetchTaxpayerObligationresponse response=httpClient.post(this.endpoint, request, FetchTaxpayerObligationresponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        } 
    }
}
