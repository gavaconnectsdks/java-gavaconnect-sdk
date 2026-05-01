package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.ExciseLicenceCheckerByCertNoRequest;
import io.github.gavaconnectsdks.dtos.responses.ExciseLicenceCheckerByCertNoResponse;
import io.github.gavaconnectsdks.dtos.responses.ExciseLicenseCheckerByPinResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

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
