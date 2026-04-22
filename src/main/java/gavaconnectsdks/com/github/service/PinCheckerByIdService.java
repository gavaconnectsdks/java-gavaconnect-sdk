package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.PinCheckerByIdRequest;
import gavaconnectsdks.com.github.dtos.responses.PinCheckerByIdResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class PinCheckerByIdService extends IService {

    public PinCheckerByIdService(GavaConfig config,GavaClient.Auth auth){
        super(config,auth);
        this.endpoint="/checker/v1/pin";
    }


    public PinCheckerByIdResponse request(PinCheckerByIdRequest request) throws IllegalAccessException,IOException,InterruptedException {
        try {
             ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            PinCheckerByIdResponse response=httpClient.post(path, request, PinCheckerByIdResponse.class, auth.getAuthorizationBearerHeader());
            return response;    
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        }
    }

}
