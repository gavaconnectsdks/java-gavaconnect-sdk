package gavaconnectsdks.com.github.service;

import java.io.IOException;

import com.fasterxml.jackson.databind.JavaType;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.ResponseWrapper;
import gavaconnectsdks.com.github.dtos.requests.NilReturnRequest;
import gavaconnectsdks.com.github.dtos.requests.TaxpayerDetailsWrapper;
import gavaconnectsdks.com.github.dtos.responses.NilReturnResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class NilReturnService extends  IService {
    public NilReturnService(GavaConfig config,Auth auth){
        super(config,auth);
        this.endpoint="/dtd/return/v1/nil";
    }

    public NilReturnResponse request(NilReturnRequest request) throws  IOException,InterruptedException,IllegalAccessException{
        try{
            ValidatorEngine.validate(request);
            int month=Integer.getInteger(request.getMonth());
            if(month<1 || month >12){
                throw new IllegalArgumentException("Month must be numeric between 01 and 12 inclusive.");
            }
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            TaxpayerDetailsWrapper<NilReturnRequest> taxpayerDetailsWrapper=new TaxpayerDetailsWrapper<>(request);
            JavaType type=this.mapper.getTypeFactory().constructParametricType(TaxpayerDetailsWrapper.class, NilReturnResponse.class);
            ResponseWrapper<NilReturnResponse> response=httpClient.post(path, taxpayerDetailsWrapper, type, auth.getAuthorizationBearerHeader());
            return response.getResponse();
    }catch(IOException  | InterruptedException | IllegalAccessException e ){
        throw  e;
    }
    }
    
}
