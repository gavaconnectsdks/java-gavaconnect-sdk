package io.github.gavaconnectsdks.service;

import java.io.IOException;

import com.fasterxml.jackson.databind.JavaType;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.ResponseWrapper;
import io.github.gavaconnectsdks.dtos.requests.TaxpayerDetailsWrapper;
import io.github.gavaconnectsdks.dtos.requests.TccApplicationRequest;
import io.github.gavaconnectsdks.dtos.responses.TccApplicationResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class TccApplicationService extends IService {
    public TccApplicationService(GavaConfig config,Auth auth){
        super(config, auth);
        this.endpoint="/application/v1/tcc";
    }

    public TccApplicationResponse request(TccApplicationRequest request) throws IOException  , InterruptedException , IllegalAccessException{
         try{
            ValidatorEngine.validate(request);
            TaxpayerDetailsWrapper<TccApplicationRequest> taxpayerDetailsWrapper=new TaxpayerDetailsWrapper<>(request);
            JavaType type=this.mapper.getTypeFactory().constructParametricType(TaxpayerDetailsWrapper.class, TccApplicationResponse.class);
            System.out.println("Request Body: "+this.mapper.writeValueAsString(taxpayerDetailsWrapper));
            ResponseWrapper<TccApplicationResponse> response=httpClient.post(this.endpoint, taxpayerDetailsWrapper, type, auth.getAuthorizationBearerHeader());
            return response.getResponse();
    }catch(IOException  | InterruptedException | IllegalAccessException e ){
        throw  e;
    }
    }
}
