package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.IncomeTaxWithPRNRequest;
import gavaconnectsdks.com.github.dtos.responses.WithholdingPRNResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class GenerateIncomeTaxWithholdingPRNService extends IService {

    public GenerateIncomeTaxWithholdingPRNService(GavaConfig config,Auth auth) {
        super(config, auth);
        this.endpoint="/generate/v1/prn/whtit";
    }

    public WithholdingPRNResponse request(IncomeTaxWithPRNRequest request) throws  IllegalAccessException,IOException,InterruptedException{
       try {
            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            WithholdingPRNResponse response=httpClient.post(path, request, WithholdingPRNResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        }  
    }

    
    
}
