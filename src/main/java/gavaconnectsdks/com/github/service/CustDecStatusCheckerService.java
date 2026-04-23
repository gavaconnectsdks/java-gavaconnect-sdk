package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.CustDecStatusCheckerRequest;
import gavaconnectsdks.com.github.dtos.responses.CustDecStatusCheckerResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class CustDecStatusCheckerService extends IService {
    public CustDecStatusCheckerService(GavaConfig config,GavaClient.Auth auth){
        super(config, auth);
        this.endpoint="/checker/v1/simple/declaration";
    }

    public CustDecStatusCheckerResponse request(CustDecStatusCheckerRequest request) throws IllegalAccessException,IOException,InterruptedException {
        try {
            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            CustDecStatusCheckerResponse response=httpClient.post(path, request, CustDecStatusCheckerResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        } 
    }
}
