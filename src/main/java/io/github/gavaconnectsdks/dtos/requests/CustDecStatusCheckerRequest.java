package io.github.gavaconnectsdks.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.gavaconnectsdks.exceptions.BadRequestException;

public class CustDecStatusCheckerRequest {

    @JsonProperty("DeclarationNo")
    private final String declarationNumber;

    private CustDecStatusCheckerRequest(Builder builder){
        this.declarationNumber=builder.declarationNumber;
    }
    public static class Builder{
        private String declarationNumber;
        
        public Builder declarationNumber(String declarationNumber) {
            this.declarationNumber = declarationNumber;
            return this;
        }
        public CustDecStatusCheckerRequest build () {
            if(this.declarationNumber==null){
                throw new BadRequestException("declarationNumber is required");
            }
            return new CustDecStatusCheckerRequest(this);
        }
        
    }

    public String getDeclarationNumber() {
        return this.declarationNumber;
    }

    public static Builder builder(){
        return new Builder();
    }
    
}
