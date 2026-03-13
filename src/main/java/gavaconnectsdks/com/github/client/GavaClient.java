package gavaconnectsdks.com.github.client;


import java.time.Instant;
import java.util.Base64;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.config.Environment;
import gavaconnectsdks.com.github.http.GavaHttpClient;

public class GavaClient {
    private final String consumerKey;
    private final String consumerSecret;
    private final Auth auth;
    private final Environment environment;
    private final GavaHttpClient httpClient;


    public GavaClient(String consumerKey,String consumerSecret,Environment environment){
        this.consumerKey=consumerKey;
        this.consumerSecret=consumerSecret;
        this.environment=environment;
        this.auth = new Auth(consumerKey,consumerSecret,environment);
        this.httpClient=GavaHttpClient.builder()
                                      .baseUrl(environment.getBaseUrl())
                                      .build();

    }

    private class OAuthObject{
        @JsonProperty("access_token")
        private String accessToken;

        @JsonProperty("expires_in")
        private Long expiresIn;

        public OAuthObject(){}
        public OAuthObject(String accessToken,Long expiresIn){
            this.accessToken=accessToken;
            this.expiresIn=expiresIn;
        }        

        public String getAccessToken() {
            return this.accessToken;
        }

        public Long getExpiresIn() {
            return this.expiresIn;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public void setExpiresIn(Long expiresIn) {
            this.expiresIn = expiresIn;
        }

    }

    private class Auth{
        private String accessToken;
        private Long expiresAt;
        private String consumerKey;
        private String consumerSecret;
        private Environment environment;

        public Auth(String consumerKey,String consumerSecret,Environment environment){
            this.consumerKey=consumerKey;
            this.consumerSecret=consumerSecret;
            this.environment=environment;
        }

        public String getAccessToken(){

            try{

            if(this.accessToken==null||this.expiresAt<Instant.now().getEpochSecond()){
                String path="/v1/token/generate?grant_type=client_credentials";
                StringBuilder ConsumerKeyConsumerSecret=new StringBuilder();
                ConsumerKeyConsumerSecret.append(this.consumerKey)
                                         .append(":")
                                         .append(this.consumerSecret);
                
                String base64ConsumerKeyConsumerSecret=Base64.getEncoder()
                                                             .encodeToString(ConsumerKeyConsumerSecret.toString().getBytes());
                Map<String,String> header=Map.ofEntries(Map.entry("Authorization","Basic "+base64ConsumerKeyConsumerSecret));
                OAuthObject response=httpClient.get(path, OAuthObject.class, header);
                this.accessToken=response.getAccessToken();
                this.expiresAt=Instant.now().getEpochSecond()+response.getExpiresIn();
            }

            return this.accessToken;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    }

    public String fileNilReturn(){

        return auth.getAccessToken();
    }
}
