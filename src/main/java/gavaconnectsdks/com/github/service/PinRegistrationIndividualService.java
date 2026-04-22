package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.PinRegistrationRequest;
import gavaconnectsdks.com.github.dtos.requests.TaxpayerDetailsWrapper;
import gavaconnectsdks.com.github.dtos.responses.PinRegistrationResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class PinRegistrationIndividualService extends IService {

    public PinRegistrationIndividualService(GavaConfig config,GavaClient.Auth auth){
        super(config, auth);
        this.endpoint="/v1/generate/pin";
    }

    public PinRegistrationResponse request(PinRegistrationRequest request) throws IOException,InterruptedException,IllegalAccessException {
        try{

            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            TaxpayerDetailsWrapper<PinRegistrationRequest> taxpayerDetailsWrapper=new TaxpayerDetailsWrapper<>(request);
            PinRegistrationResponse response=httpClient.post(path, taxpayerDetailsWrapper, PinRegistrationResponse.class, auth.getAuthorizationBearerHeader());
            return response;
    }catch(IOException  |InterruptedException | IllegalAccessException e ){
        throw  e;
    }
    }
    
}
