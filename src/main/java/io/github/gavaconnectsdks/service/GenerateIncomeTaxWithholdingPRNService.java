package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.IncomeTaxWithPRNRequest;
import io.github.gavaconnectsdks.dtos.responses.WithholdingPRNResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class GenerateIncomeTaxWithholdingPRNService extends IService {

    public GenerateIncomeTaxWithholdingPRNService(GavaConfig config,Auth auth) {
        super(config, auth);
        this.endpoint="/generate/v1/prn/whtit";
    }

    public WithholdingPRNResponse request(IncomeTaxWithPRNRequest request) throws  IllegalAccessException,IOException,InterruptedException{
       try {
            ValidatorEngine.validate(request);
            WithholdingPRNResponse response=httpClient.post(this.endpoint, request, WithholdingPRNResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        }  
    }

    
    
}
