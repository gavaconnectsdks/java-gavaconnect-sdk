package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.ExciseLicenceCheckerByCertNoRequest;
import gavaconnectsdks.com.github.dtos.responses.ExciseLicenseCheckerByPinResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class ExciseLicenceCheckerByCertificateService extends IService {

    public ExciseLicenceCheckerByCertificateService(GavaConfig config,GavaClient.Auth auth ) {
        super(config, auth);
    }

    public ExciseLicenseCheckerByPinResponse request(ExciseLicenceCheckerByCertNoRequest request) throws IllegalAccessException,IOException,InterruptedException {
        try {
            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            ExciseLicenseCheckerByPinResponse response=httpClient.post(path, request, ExciseLicenseCheckerByPinResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        }  
    }
    
    
}
