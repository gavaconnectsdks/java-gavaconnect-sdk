package io.github.gavaconnectsdks.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.http.GavaHttpClient;

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
