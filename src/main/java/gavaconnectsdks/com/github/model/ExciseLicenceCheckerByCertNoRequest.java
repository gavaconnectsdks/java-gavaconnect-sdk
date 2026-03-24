package gavaconnectsdks.com.github.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExciseLicenceCheckerByCertNoRequest {
    @JsonProperty(value="ExciseLicenseNo")
    private String exciseLicenseNumber;

    private ExciseLicenceCheckerByCertNoRequest(Builder builder){
        this.exciseLicenseNumber=builder.exciseLicenseNumber;
    }

    private static class Builder{
        private String exciseLicenseNumber;

        public Builder ExciseLicenseNumber(String exciseLicenseNumber) {
            this.exciseLicenseNumber = exciseLicenseNumber;
            return this;
        }

        public  ExciseLicenceCheckerByCertNoRequest build(){
            return  new ExciseLicenceCheckerByCertNoRequest(this);
        }
        
    }

    public String getExciseLicenseNumber() {
        return this.exciseLicenseNumber;
    }

    public static Builder builder(){
        return new Builder();
    }
    
}
