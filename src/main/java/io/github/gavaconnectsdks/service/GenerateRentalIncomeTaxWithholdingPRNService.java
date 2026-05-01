package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.RentalIncomeWithhPRNRequest;
import io.github.gavaconnectsdks.dtos.responses.WithholdingPRNResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class GenerateRentalIncomeTaxWithholdingPRNService extends IService {

    public GenerateRentalIncomeTaxWithholdingPRNService(GavaConfig config,Auth auth) {
        super(config, auth);
        this.endpoint="/generate/v1/prn/whtrental";
    }

    public WithholdingPRNResponse request(RentalIncomeWithhPRNRequest request) throws IllegalAccessException,IOException,InterruptedException{
         try {
            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            WithholdingPRNResponse response=httpClient.post(path, request, WithholdingPRNResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        } 
    }
    
    
}
