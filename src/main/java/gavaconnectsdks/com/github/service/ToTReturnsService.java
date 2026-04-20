package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.model.ToTReturnsRequest;
import gavaconnectsdks.com.github.model.ToTReturnsResponse;

public class ToTReturnsService extends  IService {

    protected String endpoint="/filing/v1/tot/paymentregistration";

    public ToTReturnsService(GavaConfig config,GavaClient.Auth auth){
        super(config, auth);
    }

    
    public ToTReturnsResponse request(ToTReturnsRequest request) throws IOException,InterruptedException {
         try{
        int month=Integer.getInteger(request.getMonth());
        if(month<1 || month >12){
            //throw an error.
        }
        String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
        ToTReturnsResponse response=httpClient.post(path, request, ToTReturnsResponse.class, auth.getAuthorizationBearerHeader());
        return response;
    }catch(IOException  |InterruptedException e ){
        throw  e;
    }
    }
    
}
