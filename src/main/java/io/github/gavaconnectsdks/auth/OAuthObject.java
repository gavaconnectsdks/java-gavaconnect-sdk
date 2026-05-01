package io.github.gavaconnectsdks.auth;

import com.fasterxml.jackson.annotation.JsonProperty;


    public  class OAuthObject{
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

