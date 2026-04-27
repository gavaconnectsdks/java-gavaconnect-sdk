package gavaconnectsdks.com.github.client.ClientFacades;

import gavaconnectsdks.com.github.dtos.requests.KnowKraOfficeRequest;
import gavaconnectsdks.com.github.dtos.responses.KnowKraOfficeResponse;
import gavaconnectsdks.com.github.exceptions.ValidationException;

public class StationFacade {
    public KnowKraOfficeResponse knowKRATaxServiceOffice(KnowKraOfficeRequest knowKraOfficeRequest){
        if(knowKraOfficeRequest==null) throw new ValidationException("Request body cannot be null");
        return null;
    }
}
