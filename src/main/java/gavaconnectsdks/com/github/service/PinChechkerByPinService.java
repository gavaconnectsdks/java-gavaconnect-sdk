package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.PinCheckerByPinRequest;
import gavaconnectsdks.com.github.dtos.responses.PinCheckerByPinResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;


public class PinChechkerByPinService extends IService {    
    public PinChechkerByPinService(GavaConfig config,GavaClient.Auth auth){
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
