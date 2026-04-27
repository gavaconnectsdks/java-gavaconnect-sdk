package gavaconnectsdks.com.github.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExciseLicenceCheckerByCertNoRequest {
    @JsonProperty(value="ExciseLicenceNo")
    private final String exciseLicenceNumber;

    private ExciseLicenceCheckerByCertNoRequest(Builder builder){
        this.exciseLicenceNumber=builder.exciseLicenceNumber;
    }

    private static class Builder{
        private String exciseLicenceNumber;

        public Builder exciseLicenceNumber(String exciseLicenceNumber) {
            this.exciseLicenceNumber = exciseLicenceNumber;
            return this;
        }

        public  ExciseLicenceCheckerByCertNoRequest build(){
            return  new ExciseLicenceCheckerByCertNoRequest(this);
        }
        
    }

    public String getExciseLicenseNumber() {
        return this.exciseLicenceNumber;
    }

    public static Builder builder(){
        return new Builder();
    }
    
}
