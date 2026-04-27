package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.ExciseLicenseCheckerByPinRequest;
import gavaconnectsdks.com.github.dtos.responses.ExciseLicenseCheckerByPinResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

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
