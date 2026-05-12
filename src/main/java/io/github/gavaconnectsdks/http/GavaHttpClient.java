package io.github.gavaconnectsdks.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import  java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.gavaconnectsdks.exceptions.BadRequestException;
import io.github.gavaconnectsdks.exceptions.FourXXXException;
import io.github.gavaconnectsdks.exceptions.BadRequestException;
import io.github.gavaconnectsdks.exceptions.ServerException;



public class GavaHttpClient {
    private final HttpClient client;
    private final ObjectMapper mapper;
    private final Duration timeout;
    private final RetryConfig retryConfig;
    private final String baseUrl;

    private GavaHttpClient(Builder builder){
        this.baseUrl=builder.baseUrl;
        this.timeout=builder.timeout;
        this.retryConfig=builder.retryConfig;
        this.mapper=builder.mapper;
        this.client=HttpClient.newBuilder()
                              .connectTimeout(timeout)
                              .build();
    }

    public static Builder builder(){
        return new Builder();
    }

    public static  class Builder{
        private ObjectMapper mapper=new ObjectMapper();
        private Duration timeout=Duration.ofSeconds(10);
        private RetryConfig retryConfig=RetryConfig.defaultConfig();
        private String baseUrl;

        public Builder baseUrl(String baseUrl){
            this.baseUrl=baseUrl;
            return this;
        }
        public Builder timeout(Duration timeout){
            this.timeout=timeout;
            return this;
        }
        public Builder retryConfig(RetryConfig retryConfig){
            this.retryConfig=retryConfig;
            return this;
        }
        public Builder objectMapper(ObjectMapper mapper){
            this.mapper=mapper;
            return this;
        }
        public GavaHttpClient build(){
            return new GavaHttpClient(this);
        }
    }


    private HttpRequest.Builder baseRequest(String path){
        return HttpRequest.newBuilder()
                          .uri(URI.create(baseUrl+path))
                          .timeout(timeout)
                          .header("Content-Type", "application/json")
                          .header("Accept", "application/json");
    }

    private void backoff(int attempt){
        try {
            Thread.sleep(retryConfig.getBackoffInMilliseconds()*(attempt+1));
        } catch (InterruptedException e) {
        }
    }

    private HttpResponse<String> executeWithRetry(HttpRequest request)throws IOException,InterruptedException{
        int attempt=0;
        while(true){
            try {
                HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
                if(response.statusCode()>=500 && attempt<retryConfig.getMaxRetries()){
                    backoff(attempt++);
                    continue;
                }
                return response;
            } catch (IOException|InterruptedException e) {
                if(attempt>=retryConfig.getMaxRetries()){
                    throw e;
                }
                backoff(attempt++);
            }
        }

    }

    private CompletableFuture<HttpResponse<String>> executeAsyncWithRetry(HttpRequest request){
        return  executeAsyncWithRetry(request,0);
    }
    private CompletableFuture<HttpResponse<String>> executeAsyncWithRetry(HttpRequest request,int attempt){
        return  client.sendAsync(request,HttpResponse.BodyHandlers.ofString())
                      .handle((resp,ex)->{
                        if(ex!=null){
                            if(attempt<retryConfig.getMaxRetries()){
                                backoff(attempt);
                                return  executeAsyncWithRetry(request,attempt+1).join();
                            }
                            throw new RuntimeException(ex);
                        }
                        if(resp.statusCode()>=500 && attempt<retryConfig.getMaxRetries()){
                            backoff(attempt);
                            return executeAsyncWithRetry(request,attempt+1).join();
                        }
                        return resp;
                      });
    }


    //SYNC REQUESTS

    public <T> T get (String path,Class<T> responseType,Map<String,String> header) throws IOException,InterruptedException {
        try{
        HttpRequest.Builder requestBuilder=baseRequest(path)
                            .GET();

        for (Map.Entry<String, String> en : header.entrySet()) {
            requestBuilder.header(en.getKey(), en.getValue());
        }

        HttpResponse<String> response=executeWithRetry(requestBuilder.build());

        return mapper.readValue(response.body(), responseType);
        }catch(JsonProcessingException e){
            throw  e;
        }
    }


    public <T> T post (String path,Object body,JavaType responseType,String accessToken) throws IOException,InterruptedException {
        String json=mapper.writeValueAsString(body);

        HttpRequest request=baseRequest(path)
                            .POST(HttpRequest.BodyPublishers.ofString(json))
                            .header("Authorization", "Bearer "+accessToken)
                            .build();
        HttpResponse<String> response=executeWithRetry(request);
        System.out.println(response.statusCode()+" "+response.body());
        if (response.statusCode()>=400 && response.statusCode()<500) {
            throw  new FourXXXException(response.body(),"ERR_"+response.statusCode());
        }
        if(response.statusCode()>=500){
            throw new ServerException("Server error: "+response.body());
        }
        System.out.println(response.statusCode()+" "+response.body());
        return mapper.readValue(response.body(), responseType);
    }
     public <T> T post (String path,Object body,Class<T> responseType,String accessToken) throws IOException,InterruptedException {
        String json=mapper.writeValueAsString(body);

        System.out.println("Request Body: " + json+" path "+path +" accessToken "+accessToken);
        HttpRequest request=baseRequest(path)
                            .POST(HttpRequest.BodyPublishers.ofString(json))
                            .header("Authorization", "Bearer "+accessToken)
                            .build();
        HttpResponse<String> response=executeWithRetry(request);
        if (response.statusCode()>=400 && response.statusCode()<500) {
            throw  new FourXXXException(response.body(),"ERR_"+response.statusCode());
        }
        if(response.statusCode()>=500){
            throw new ServerException("Server error: "+response.body());
        }
        System.out.println(response.statusCode()+" "+response.body());

        return mapper.readValue(response.body(), responseType);
    }

      public <T> CompletableFuture<T> getAsync (String path,Class<T> responseType,Map<String,String> header) throws IOException,InterruptedException {
        
         HttpRequest.Builder requestBuilder=baseRequest(path)
                            .GET();

        for (Map.Entry<String, String> en : header.entrySet()) {
            requestBuilder.header(en.getKey(), en.getValue());
        }

        return executeAsyncWithRetry(requestBuilder.build())
               .thenApply(HttpResponse::body)
               .thenApply(body->{
                try {
                    return mapper.readValue(body, responseType);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
               });
    }
    public <T> CompletableFuture<T> postAsync (String path,Object body,Class<T> responseType,String accessToken) throws IOException,InterruptedException {
        try{
        String json=mapper.writeValueAsString(body);
        HttpRequest request=baseRequest(path)
                            .POST(HttpRequest.BodyPublishers.ofString(json))
                            .header("Authorization", "Bearer "+accessToken)
                            .build();
        HttpResponse<String> response=executeWithRetry(request);

        return executeAsyncWithRetry(request)
               .thenApply(HttpResponse::body)
               .thenApply(bod->{
                try {
                    return mapper.readValue(bod, responseType);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
               });
            }catch(Exception e){
                return CompletableFuture.failedFuture(e);
            }
    }

    
}
