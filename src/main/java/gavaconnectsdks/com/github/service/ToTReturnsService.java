package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.TaxpayerDetailsWrapper;
import gavaconnectsdks.com.github.dtos.requests.ToTReturnsRequest;
import gavaconnectsdks.com.github.dtos.responses.ToTReturnsResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

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
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            TaxpayerDetailsWrapper<ToTReturnsRequest> taxpayerDetailsWrapper=new TaxpayerDetailsWrapper<>(request);
            ToTReturnsResponse response=httpClient.post(path, taxpayerDetailsWrapper, ToTReturnsResponse.class, auth.getAuthorizationBearerHeader());
            return response;
    }catch(IOException  |InterruptedException | IllegalAccessException e ){
        throw  e;
    }
    }
    
}
