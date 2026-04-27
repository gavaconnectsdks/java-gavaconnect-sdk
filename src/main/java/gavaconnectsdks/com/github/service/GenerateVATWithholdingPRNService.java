package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.VatWithhPRNRequest;
import gavaconnectsdks.com.github.dtos.responses.WithholdingPRNResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class GenerateVATWithholdingPRNService extends IService {

    public GenerateVATWithholdingPRNService(GavaConfig config,Auth auth) {
        super(config, auth);
        this.endpoint="/generate/v1/prn/whtvat";
    }
    
    public WithholdingPRNResponse request(VatWithhPRNRequest request) throws IllegalAccessException,IOException,InterruptedException {
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
