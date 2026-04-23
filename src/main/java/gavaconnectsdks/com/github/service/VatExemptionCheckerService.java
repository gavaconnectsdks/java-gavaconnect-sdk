package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.VatExcemptionCheckerRequest;
import gavaconnectsdks.com.github.dtos.responses.VatExcemptionCheckerResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class VatExemptionCheckerService extends IService {
    public VatExemptionCheckerService(GavaConfig config,GavaClient.Auth auth){
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
