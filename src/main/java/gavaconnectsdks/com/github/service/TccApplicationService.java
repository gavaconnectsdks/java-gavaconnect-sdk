package gavaconnectsdks.com.github.service;

import java.io.IOException;

import com.fasterxml.jackson.databind.JavaType;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.ResponseWrapper;
import gavaconnectsdks.com.github.dtos.requests.TaxpayerDetailsWrapper;
import gavaconnectsdks.com.github.dtos.requests.TccApplicationRequest;
import gavaconnectsdks.com.github.dtos.responses.TccApplicationResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class TccApplicationService extends IService {
    public TccApplicationService(GavaConfig config,Auth auth){
        super(config, auth);
        this.endpoint="/application/v1/tcc";
    }

    public TccApplicationResponse request(TccApplicationRequest request) throws IOException  , InterruptedException , IllegalAccessException{
         try{
            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            TaxpayerDetailsWrapper<TccApplicationRequest> taxpayerDetailsWrapper=new TaxpayerDetailsWrapper<>(request);
            JavaType type=this.mapper.getTypeFactory().constructParametricType(TaxpayerDetailsWrapper.class, TccApplicationResponse.class);
            ResponseWrapper<TccApplicationResponse> response=httpClient.post(path, taxpayerDetailsWrapper, type, auth.getAuthorizationBearerHeader());
            return response.getResponse();
    }catch(IOException  | InterruptedException | IllegalAccessException e ){
        throw  e;
    }
    }
}
