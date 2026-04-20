package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.model.NilReturnRequest;
import gavaconnectsdks.com.github.model.NilReturnResponse;

public class NilReturnService extends  IService {
    protected  String endpoint="/dtd/return/v1/nil";

    public NilReturnService(GavaConfig config,GavaClient.Auth auth){
        super(config,auth);
    }

    public NilReturnResponse request(NilReturnRequest request) throws  IOException,InterruptedException {

        try{
        int month=Integer.getInteger(request.getMonth());
        if(month<1 || month >12){
            //throw an error.
        }
        String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
        NilReturnResponse response=httpClient.post(path, request, NilReturnResponse.class, auth.getAuthorizationBearerHeader());
        return response;
    }catch(IOException  |InterruptedException e ){
        throw  e;
    }
    }
    
}
