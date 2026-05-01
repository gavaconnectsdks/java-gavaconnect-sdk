package io.github.gavaconnectsdks.service;

import java.io.IOException;

import com.fasterxml.jackson.databind.JavaType;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.ResponseWrapper;
import io.github.gavaconnectsdks.dtos.requests.NilReturnRequest;
import io.github.gavaconnectsdks.dtos.requests.TaxpayerDetailsWrapper;
import io.github.gavaconnectsdks.dtos.responses.NilReturnResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

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
