package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.CustDecStatusCheckerRequest;
import io.github.gavaconnectsdks.dtos.responses.CustDecStatusCheckerResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class CustDecStatusCheckerService extends IService {
    public CustDecStatusCheckerService(GavaConfig config,Auth auth){
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
