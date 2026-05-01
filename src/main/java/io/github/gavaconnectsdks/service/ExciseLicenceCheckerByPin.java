package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.ExciseLicenseCheckerByPinRequest;
import io.github.gavaconnectsdks.dtos.responses.ExciseLicenseCheckerByPinResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class ExciseLicenceCheckerByPin extends IService {

    public ExciseLicenceCheckerByPin(GavaConfig config,Auth auth) {
        super(config, auth);
        this.endpoint="/checker/v1/ExciseLicenseByPin";
    }

    public ExciseLicenseCheckerByPinResponse request(ExciseLicenseCheckerByPinRequest request) throws IllegalAccessException,IOException,InterruptedException{
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
