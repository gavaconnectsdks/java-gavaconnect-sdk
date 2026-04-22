package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.KnowKraOfficeRequest;
import gavaconnectsdks.com.github.dtos.responses.KnowKraOfficeResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class KnowKRATaxOfficeService extends IService {
    public KnowKRATaxOfficeService(GavaConfig config,GavaClient.Auth auth) {
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
