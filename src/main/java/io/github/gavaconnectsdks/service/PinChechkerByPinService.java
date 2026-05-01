package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.PinCheckerByPinRequest;
import io.github.gavaconnectsdks.dtos.responses.PinCheckerByPinResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;


public class PinChechkerByPinService extends IService {    
    public PinChechkerByPinService(GavaConfig config,Auth auth){
        super(config,auth);
        this.endpoint="/checker/v1/pinbypin";
    }

    
    public PinCheckerByPinResponse request(PinCheckerByPinRequest request) throws IllegalAccessException,IOException,InterruptedException {
        try {
            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            PinCheckerByPinResponse response=httpClient.post(path, request, PinCheckerByPinResponse.class, auth.getAuthorizationBearerHeader());
            return response;
        } catch (IOException  | InterruptedException | IllegalAccessException e ) {
            throw e;
        }
        
    }
}
