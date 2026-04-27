package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.TccCheckerrequest;
import gavaconnectsdks.com.github.dtos.responses.TccCheckerResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class TccCheckerService extends IService {
    public TccCheckerService (GavaConfig config,Auth auth){
        super(config, auth);
        this.endpoint="/v1/kra-tcc/validate";
    }

    public TccCheckerResponse request(TccCheckerrequest request) throws IllegalAccessException,IOException,InterruptedException{
        try {
            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            TccCheckerResponse response=httpClient.post(path, request, TccCheckerResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        } 
    }
}
