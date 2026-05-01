package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.KnowKraOfficeRequest;
import io.github.gavaconnectsdks.dtos.responses.KnowKraOfficeResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class KnowKRATaxOfficeService extends IService {
    public KnowKRATaxOfficeService(GavaConfig config,Auth auth) {
        super(config,auth);
        this.endpoint="dtd/checker/v1/station";
    }

    
    public KnowKraOfficeResponse request(KnowKraOfficeRequest request)throws IllegalAccessException,IOException,InterruptedException {
        try {
            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            KnowKraOfficeResponse response=httpClient.post(path, request, KnowKraOfficeResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        }
    }
}
