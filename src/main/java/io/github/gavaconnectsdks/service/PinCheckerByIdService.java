package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.PinCheckerByIdRequest;
import io.github.gavaconnectsdks.dtos.responses.PinCheckerByIdResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class PinCheckerByIdService extends IService {

    public PinCheckerByIdService(GavaConfig config,Auth auth){
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
