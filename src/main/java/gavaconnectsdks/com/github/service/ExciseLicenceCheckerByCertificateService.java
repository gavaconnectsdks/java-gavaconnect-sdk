package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.ExciseLicenceCheckerByCertNoRequest;
import gavaconnectsdks.com.github.dtos.responses.ExciseLicenceCheckerByCertNoResponse;
import gavaconnectsdks.com.github.dtos.responses.ExciseLicenseCheckerByPinResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class ExciseLicenceCheckerByCertificateService extends IService {

    public ExciseLicenceCheckerByCertificateService(GavaConfig config,Auth auth ) {
        super(config, auth);
    }

    public ExciseLicenceCheckerByCertNoResponse request(ExciseLicenceCheckerByCertNoRequest request) throws IllegalAccessException,IOException,InterruptedException {
        try {
            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            ExciseLicenceCheckerByCertNoResponse response=httpClient.post(path, request, ExciseLicenceCheckerByCertNoResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        }  
    }
    
    
}
