package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.PinRegistrationRequest;
import io.github.gavaconnectsdks.dtos.requests.TaxpayerDetailsWrapper;
import io.github.gavaconnectsdks.dtos.responses.PinRegistrationResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class PinRegistrationIndividualService extends IService {

    public PinRegistrationIndividualService(GavaConfig config,Auth auth){
        super(config, auth);
        this.endpoint="/v1/generate/pin";
    }

    public PinRegistrationResponse request(PinRegistrationRequest request) throws IOException,InterruptedException,IllegalAccessException {
        try{

            ValidatorEngine.validate(request);
            TaxpayerDetailsWrapper<PinRegistrationRequest> taxpayerDetailsWrapper=new TaxpayerDetailsWrapper<>(request);
            PinRegistrationResponse response=httpClient.post(this.endpoint, taxpayerDetailsWrapper, PinRegistrationResponse.class, auth.getAuthorizationBearerHeader());
            return response;
    }catch(IOException  |InterruptedException | IllegalAccessException e ){
        throw  e;
    }
    }
    
}
