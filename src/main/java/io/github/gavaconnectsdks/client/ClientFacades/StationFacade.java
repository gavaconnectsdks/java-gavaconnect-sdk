package io.github.gavaconnectsdks.client.ClientFacades;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.KnowKraOfficeRequest;
import io.github.gavaconnectsdks.dtos.responses.KnowKraOfficeResponse;
import io.github.gavaconnectsdks.exceptions.ValidationException;
import io.github.gavaconnectsdks.service.KnowKRATaxOfficeService;

public class StationFacade {
    private final GavaConfig config;
    private final Auth auth;

    public StationFacade(GavaConfig config,Auth auth){
        this.auth=auth;
        this.config=config;
    }
    public KnowKraOfficeResponse knowKRATaxServiceOffice(KnowKraOfficeRequest knowKraOfficeRequest)throws IOException ,InterruptedException,IllegalAccessException{
        try {
               if(knowKraOfficeRequest==null) throw new ValidationException("Request body is required.");
               KnowKRATaxOfficeService knowKRATaxOfficeService= new KnowKRATaxOfficeService(this.config, this.auth);
               return knowKRATaxOfficeService.request(knowKraOfficeRequest);
        } catch (IOException|InterruptedException|IllegalAccessException e) {
            throw e;
        }
     
    }
}
