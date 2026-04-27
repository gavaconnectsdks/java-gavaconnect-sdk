package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.RentalIncomeWithhPRNRequest;
import gavaconnectsdks.com.github.dtos.responses.WithholdingPRNResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

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
