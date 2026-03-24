package gavaconnectsdks.com.github.model;

import gavaconnectsdks.com.github.utils.annotations.CountryCode;

public class PinCheckerByIdRequest {
    @CountryCode
    private String TaxpayerType;
    private String TaxpayerID;

    private PinCheckerByIdRequest(Builder builder){
        this.TaxpayerID=builder.TaxpayerID;
        this.TaxpayerType=builder.TaxpayerType;
    }

    private static class Builder{
        @CountryCode
        private String TaxpayerType;
        private String TaxpayerID;

        public Builder TaxpayerID(String TaxpayerID) {
            this.TaxpayerID = TaxpayerID;
            return this;
        }

        public Builder TaxpayerType(String TaxpayerType) {
            this.TaxpayerType = TaxpayerType;
            return this;
        }

        public PinCheckerByIdRequest build(){
            return new PinCheckerByIdRequest(this);
        }
        
        
    }

    public String getTaxpayerID() {
        return this.TaxpayerID;
    }

    public String getTaxpayerType() {
        return this.TaxpayerType;
    }

    public static  Builder builder(){
        return new Builder();
    }
}
