package gavaconnectsdks.com.github.client.ClientFacades;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.KnowKraOfficeRequest;
import gavaconnectsdks.com.github.dtos.responses.KnowKraOfficeResponse;
import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.service.KnowKRATaxOfficeService;

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
