package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.TaxpayerDetailsWrapper;
import io.github.gavaconnectsdks.dtos.requests.ToTReturnsRequest;
import io.github.gavaconnectsdks.dtos.responses.ToTReturnsResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class ToTReturnsService extends  IService {
    public ToTReturnsService(GavaConfig config,Auth auth){
        super(config, auth);
        this.endpoint="/filing/v1/tot/paymentregistration";
    }

    
    public ToTReturnsResponse request(ToTReturnsRequest request) throws IOException,InterruptedException,IllegalAccessException {
         try{

            ValidatorEngine.validate(request);
            int month=Integer.getInteger(request.getMonth());
            if(month<1 || month >12){
                throw new IllegalArgumentException("Month must be numeric between 01 and 12 inclusive.");
            }
            TaxpayerDetailsWrapper<ToTReturnsRequest> taxpayerDetailsWrapper=new TaxpayerDetailsWrapper<>(request);
            ToTReturnsResponse response=httpClient.post(this.endpoint, taxpayerDetailsWrapper, ToTReturnsResponse.class, auth.getAuthorizationBearerHeader());
            return response;
    }catch(IOException  |InterruptedException | IllegalAccessException e ){
        throw  e;
    }
    }
    
}
