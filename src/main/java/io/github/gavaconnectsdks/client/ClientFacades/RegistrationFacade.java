package io.github.gavaconnectsdks.client.ClientFacades;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.PinRegistrationRequest;
import io.github.gavaconnectsdks.dtos.responses.PinRegistrationResponse;
import io.github.gavaconnectsdks.exceptions.BadRequestException;
import io.github.gavaconnectsdks.service.PinRegistrationIndividualService;

public class RegistrationFacade {

    private final GavaConfig config;
    private final Auth auth;

    public RegistrationFacade(GavaConfig config,Auth auth){
        this.config=config;
        this.auth=auth;
    }


    public PinRegistrationResponse registerKRAPINIndividual(PinRegistrationRequest pinRegistrationRequest)throws IOException ,InterruptedException,IllegalAccessException{
        try {
                if(pinRegistrationRequest==null) throw new BadRequestException("Request body is required.");
                PinRegistrationIndividualService pinRegistrationIndividualService=new PinRegistrationIndividualService(this.config, this.auth);
                return pinRegistrationIndividualService.request(pinRegistrationRequest);
            
        } catch (IOException|InterruptedException|IllegalAccessException e) {
            throw e;
        }

    }   
}
