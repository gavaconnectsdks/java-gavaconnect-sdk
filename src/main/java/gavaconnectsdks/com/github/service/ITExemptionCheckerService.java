package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.ITExceptionCheckerRequest;
import gavaconnectsdks.com.github.dtos.requests.TaxpayerDetailsWrapper;
import gavaconnectsdks.com.github.dtos.responses.ITExemptionCheckerResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

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
