package gavaconnectsdks.com.github.client.ClientFacades;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.NilReturnRequest;
import gavaconnectsdks.com.github.dtos.requests.ToTReturnsRequest;
import gavaconnectsdks.com.github.dtos.responses.NilReturnResponse;
import gavaconnectsdks.com.github.dtos.responses.ToTReturnsResponse;
import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.service.NilReturnService;
import gavaconnectsdks.com.github.service.ToTReturnsService;

public class ReturnsFacade {
    private final GavaConfig config;
    private final Auth auth;

    public ReturnsFacade(GavaConfig config,Auth auth){
        this.config=config;
        this.auth=auth;
    }

    public NilReturnResponse fileNilReturn(NilReturnRequest nilReturnRequest)throws IOException ,InterruptedException,IllegalAccessException{
        try {
               if(nilReturnRequest==null) throw new ValidationException("Request body is required.");
               NilReturnService nilReturnService=new NilReturnService(this.config,this.auth);
              return nilReturnService.request(nilReturnRequest);
        } catch (IOException |InterruptedException|IllegalAccessException e) {
            throw e;
        }
     
    }

    public ToTReturnsResponse fileTurnOverTaxReturn(ToTReturnsRequest toTReturnsRequest)throws IOException ,InterruptedException,IllegalAccessException{
        try {
              if(toTReturnsRequest==null) throw new ValidationException("Request body is required.");
              ToTReturnsService toTReturnsService=new ToTReturnsService(this.config, this.auth);
              return toTReturnsService.request(toTReturnsRequest);
        } catch (IOException|InterruptedException|IllegalAccessException e) {
            throw e;
        }
      
    } 
}
