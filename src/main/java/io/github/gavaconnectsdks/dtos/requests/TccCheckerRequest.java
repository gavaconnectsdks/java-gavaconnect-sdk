package io.github.gavaconnectsdks.dtos.requests;

import io.github.gavaconnectsdks.exceptions.BadRequestException;
import io.github.gavaconnectsdks.utils.annotations.Pin;

public class TccCheckerRequest {
    @Pin
    private final String kraPIN;
    private  final String tccNumber;

    private TccCheckerRequest(Builder builder){
        this.kraPIN=builder.kraPIN;
        this.tccNumber=builder.tccNumber;
    }

    public static class Builder{
        private  String kraPIN;
        private String tccNumber;


        public Builder kraPIN(String kraPIN) {
            this.kraPIN = kraPIN;
            return this;
        }

        public Builder tccNumber(String tccNumber) {
            this.tccNumber = tccNumber;
            return this;
        }

        public TccCheckerRequest build(){
            if (this.kraPIN==null) {
                throw new BadRequestException("kraPIN is required");
            }
            if (this.tccNumber==null) {
                throw new BadRequestException("tccNumber is required");
            }
            return new TccCheckerRequest(this);
        }
        
    }

    public String getKraPIN() {
        return this.kraPIN;
    }

    public String getTccNumber() {
        return this.tccNumber;
    }

    public static Builder builder(){
        return new Builder();
    }
    
}
