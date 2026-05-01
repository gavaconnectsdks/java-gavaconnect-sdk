package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.ITExceptionCheckerRequest;
import io.github.gavaconnectsdks.dtos.requests.TaxpayerDetailsWrapper;
import io.github.gavaconnectsdks.dtos.responses.ITExemptionCheckerResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class ITExemptionCheckerService extends IService {
    public ITExemptionCheckerService(GavaConfig config,Auth auth){
        super(config, auth);
        this.endpoint="/checker/v1/itexemption";
    }
    
    public ITExemptionCheckerResponse request(ITExceptionCheckerRequest request) throws IOException  ,InterruptedException , IllegalAccessException {
        try{
            ValidatorEngine.validate(request);    
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            TaxpayerDetailsWrapper<ITExceptionCheckerRequest> taxpayerDetailsWrapper=new TaxpayerDetailsWrapper<>(request);
            ITExemptionCheckerResponse response=httpClient.post(path, taxpayerDetailsWrapper, ITExemptionCheckerResponse.class, auth.getAuthorizationBearerHeader());
            return response;
        }catch(IOException  |InterruptedException | IllegalAccessException e ){
            throw  e;
        }
    }
}
