package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.VatExcemptionCheckerRequest;
import io.github.gavaconnectsdks.dtos.responses.VatExcemptionCheckerResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class VatExemptionCheckerService extends IService {
    public VatExemptionCheckerService(GavaConfig config,Auth auth){
        super(config, auth);
        this.endpoint="/checker/v1/vatexemption";
    }

    public VatExcemptionCheckerResponse requst(VatExcemptionCheckerRequest request) throws IllegalAccessException,IOException,InterruptedException{
        try {
            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            VatExcemptionCheckerResponse response=httpClient.post(path, request, VatExcemptionCheckerResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        } 
    }
}
