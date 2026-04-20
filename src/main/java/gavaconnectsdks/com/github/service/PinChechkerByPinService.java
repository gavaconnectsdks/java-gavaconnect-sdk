package gavaconnectsdks.com.github.service;

import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.model.GavaRequest;
import gavaconnectsdks.com.github.model.GavaResponse;


public class PinChechkerByPinService extends IService {
    private String endpoint="/checker/v1/pinbypin";
    
    public PinChechkerByPinService(GavaConfig config,GavaClient.Auth auth){
        super(config,auth);
    }

    @Override
    public GavaResponse request(GavaRequest request){
        return null;
    }
}
