package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.VatWithhPRNRequest;
import io.github.gavaconnectsdks.dtos.responses.WithholdingPRNResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

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
