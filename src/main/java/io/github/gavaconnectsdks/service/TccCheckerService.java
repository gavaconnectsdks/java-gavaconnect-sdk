package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.TccCheckerRequest;
import io.github.gavaconnectsdks.dtos.responses.TccCheckerResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class TccCheckerService extends IService {
    public TccCheckerService (GavaConfig config,Auth auth){
        super(config, auth);
        this.endpoint="/v1/kra-tcc/validate";
    }

    public TccCheckerResponse request(TccCheckerRequest request) throws IllegalAccessException,IOException,InterruptedException{
        try {
            ValidatorEngine.validate(request);
            TccCheckerResponse response=httpClient.post(this.endpoint, request, TccCheckerResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        } 
    }
}
