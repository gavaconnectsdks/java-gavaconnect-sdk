package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.FetchTaxpayerObligationRequest;
import gavaconnectsdks.com.github.dtos.responses.FetchTaxpayerObligationresponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class TaxPayerObligationService extends IService {
    public TaxPayerObligationService(GavaConfig config,Auth auth){
        super(config, auth);
        this.endpoint="/dtd/checker/v1/obligation";
    }

    public FetchTaxpayerObligationresponse request(FetchTaxpayerObligationRequest request) throws IllegalAccessException,IOException,InterruptedException {
        try {
            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            FetchTaxpayerObligationresponse response=httpClient.post(path, request, FetchTaxpayerObligationresponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        } 
    }
}
