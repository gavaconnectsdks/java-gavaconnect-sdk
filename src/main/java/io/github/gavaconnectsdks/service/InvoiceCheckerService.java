package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.InvoiceCheckerRequest;
import io.github.gavaconnectsdks.dtos.responses.InvoiceCheckerResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class InvoiceCheckerService extends IService {
    
    public InvoiceCheckerService(GavaConfig config,Auth auth){
        super(config, auth);
        this.endpoint="/checker/v1/invoice";
    }

    public InvoiceCheckerResponse request(InvoiceCheckerRequest request)throws IllegalAccessException,IOException,InterruptedException  {
        try {
            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            InvoiceCheckerResponse response=httpClient.post(path, request, InvoiceCheckerResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        }  
    }
}
