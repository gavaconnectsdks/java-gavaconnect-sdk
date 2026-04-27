package gavaconnectsdks.com.github.client.ClientFacades;

import gavaconnectsdks.com.github.dtos.requests.NilReturnRequest;
import gavaconnectsdks.com.github.dtos.requests.ToTReturnsRequest;
import gavaconnectsdks.com.github.dtos.responses.NilReturnResponse;
import gavaconnectsdks.com.github.dtos.responses.ToTReturnsResponse;
import gavaconnectsdks.com.github.exceptions.ValidationException;

public class ReturnsFacade {
    public NilReturnResponse fileNilReturn(NilReturnRequest nilReturnRequest){
        if(nilReturnRequest==null) throw new ValidationException("Request body cannot be null");

           return null;
    }

    public ToTReturnsResponse fileTurnOverTaxReturn(ToTReturnsRequest toTReturnsRequest){
        if(toTReturnsRequest==null) throw new ValidationException("Request body cannot be null");
        return null;
    } 
}
