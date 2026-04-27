package gavaconnectsdks.com.github.auth;

import java.time.Instant;
import java.util.Base64;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import  com.fasterxml.jackson.databind.ObjectMapper;

import gavaconnectsdks.com.github.config.Environment;
import gavaconnectsdks.com.github.http.GavaHttpClient;

public class Auth{
        private String accessToken;
        private Long expiresAt;
        private String consumerKey;
        private String consumerSecret;
        private Environment environment;
        private GavaHttpClient httpClient;
        private ObjectMapper objectMapper = new ObjectMapper();

        public Auth(String consumerKey,String consumerSecret,Environment environment,GavaHttpClient httpClient){
            this.consumerKey=consumerKey;
            this.consumerSecret=consumerSecret;
            this.environment=environment;
            this.httpClient=httpClient;
        }

        public synchronized String getAuthorizationBearerHeader() throws JsonProcessingException {
            return objectMapper.writeValueAsString(Map.ofEntries(Map.entry("Authorization", "Bearer "+this.getAccessToken())));   
        }

        public synchronized String getAccessToken(){

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

