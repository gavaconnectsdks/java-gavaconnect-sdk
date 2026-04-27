package gavaconnectsdks.com.github.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.http.GavaHttpClient;

public class IService {
    protected GavaConfig config;
    protected Auth auth;
    protected GavaHttpClient httpClient;
    protected String endpoint;
    protected ObjectMapper mapper;

    public IService(GavaConfig config,Auth auth){
        this.config=config;
        this.auth=auth;
        this.mapper=new ObjectMapper();
        this.httpClient=GavaHttpClient.builder()
                                      .baseUrl(config.getEnvironment().getBaseUrl())
                                      .build();
    }
    
}
