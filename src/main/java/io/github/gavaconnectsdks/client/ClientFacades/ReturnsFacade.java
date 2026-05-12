package io.github.gavaconnectsdks.client.ClientFacades;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.NilReturnRequest;
import io.github.gavaconnectsdks.dtos.requests.ToTReturnsRequest;
import io.github.gavaconnectsdks.dtos.responses.NilReturnResponse;
import io.github.gavaconnectsdks.dtos.responses.ToTReturnsResponse;
import io.github.gavaconnectsdks.exceptions.BadRequestException;
import io.github.gavaconnectsdks.service.NilReturnService;
import io.github.gavaconnectsdks.service.ToTReturnsService;

public class ReturnsFacade {
    private final GavaConfig config;
    private final Auth auth;

    public ReturnsFacade(GavaConfig config,Auth auth){
        this.config=config;
        this.auth=auth;
    }

    public NilReturnResponse fileNilReturn(NilReturnRequest nilReturnRequest)throws IOException ,InterruptedException,IllegalAccessException{
        try {
               if(nilReturnRequest==null) throw new BadRequestException("Request body is required.");
               NilReturnService nilReturnService=new NilReturnService(this.config,this.auth);
              return nilReturnService.request(nilReturnRequest);
        } catch (IOException |InterruptedException|IllegalAccessException e) {
            throw e;
        }
     
    }

    public ToTReturnsResponse fileTurnOverTaxReturn(ToTReturnsRequest toTReturnsRequest)throws IOException ,InterruptedException,IllegalAccessException{
        try {
              if(toTReturnsRequest==null) throw new BadRequestException("Request body is required.");
              ToTReturnsService toTReturnsService=new ToTReturnsService(this.config, this.auth);
              return toTReturnsService.request(toTReturnsRequest);
        } catch (IOException|InterruptedException|IllegalAccessException e) {
            throw e;
        }
      
    } 
}
