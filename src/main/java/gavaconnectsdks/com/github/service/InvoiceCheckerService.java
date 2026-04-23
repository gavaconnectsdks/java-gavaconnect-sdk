package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.InvoiceCheckerRequest;
import gavaconnectsdks.com.github.dtos.responses.InvoiceCheckerResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class InvoiceCheckerService extends IService {
    
    public InvoiceCheckerService(GavaConfig config,GavaClient.Auth auth){
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
