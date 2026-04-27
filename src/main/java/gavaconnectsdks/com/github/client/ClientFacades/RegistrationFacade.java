package gavaconnectsdks.com.github.client.ClientFacades;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.PinRegistrationRequest;
import gavaconnectsdks.com.github.dtos.responses.PinRegistrationResponse;
import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.service.PinRegistrationIndividualService;

public class RegistrationFacade {

    private final GavaConfig config;
    private final Auth auth;

    public RegistrationFacade(GavaConfig config,Auth auth){
        this.config=config;
        this.auth=auth;
    }


    public PinRegistrationResponse registerKRAPINIndividual(PinRegistrationRequest pinRegistrationRequest)throws IOException ,InterruptedException,IllegalAccessException{
        try {
                if(pinRegistrationRequest==null) throw new ValidationException("Request body is required.");
                PinRegistrationIndividualService pinRegistrationIndividualService=new PinRegistrationIndividualService(this.config, this.auth);
                return pinRegistrationIndividualService.request(pinRegistrationRequest);
            
        } catch (IOException|InterruptedException|IllegalAccessException e) {
            throw e;
        }

    }   
}
