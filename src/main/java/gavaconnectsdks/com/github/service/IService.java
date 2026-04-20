package gavaconnectsdks.com.github.service;

import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.http.GavaHttpClient;
import gavaconnectsdks.com.github.model.GavaRequest;
import gavaconnectsdks.com.github.model.GavaResponse;

public class IService {
    protected GavaConfig config;
    protected GavaClient.Auth auth;
    protected GavaHttpClient httpClient;
    protected String endpoint;


    public IService(GavaConfig config,GavaClient.Auth auth){
        this.config=config;
        this.auth=auth;
        this.httpClient=GavaHttpClient.builder()
                                      .baseUrl(config.getEnvironment().getBaseUrl())
                                      .build();
    }

    public GavaResponse request(GavaRequest request){
        
        return null;
    }
    
}
