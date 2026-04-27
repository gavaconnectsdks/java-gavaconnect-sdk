package gavaconnectsdks.com.github.client.ClientFacades;

import gavaconnectsdks.com.github.dtos.requests.PinRegistrationRequest;
import gavaconnectsdks.com.github.dtos.responses.PinRegistrationResponse;
import gavaconnectsdks.com.github.exceptions.ValidationException;

public class RegistrationFacade {
    public PinRegistrationResponse registerKRAPINIndividual(PinRegistrationRequest pinRegistrationRequest){
        if(pinRegistrationRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }   
}
