package gavaconnectsdks.com.github.model;

import gavaconnectsdks.com.github.utils.annotations.CustomPattern;
import gavaconnectsdks.com.github.utils.annotations.Pin;

public class ToTReturnsRequest {
    @Pin
    private String TaxpayerPIN;

    @CustomPattern(pattern="^\\d{2}$")
    private String Month;

    @CustomPattern(pattern="^\\d{2}$")
    private String Year;

    private float GrossTurnOver;


    private ToTReturnsRequest(Builder builder){
        this.GrossTurnOver=builder.GrossTurnOver;
        this.Month=builder.Month;
        this.TaxpayerPIN=builder.TaxpayerPIN;
        this.Year=builder.Year;
    }

    private static class Builder{
        private String TaxpayerPIN;

        private String Month;

        private String Year;

        private float GrossTurnOver;

        public Builder GrossTurnOver(float GrossTurnOver) {
            this.GrossTurnOver = GrossTurnOver;
            return this;
        }

        public Builder Month(String Month) {
            this.Month = Month;
            return this;
        }

        public Builder TaxpayerPIN(String TaxpayerPIN) {
            this.TaxpayerPIN = TaxpayerPIN;
            return this;
        }

        public Builder Year(String Year) {
            this.Year = Year;
            return this;
        }

        public ToTReturnsRequest build(){
            return new ToTReturnsRequest(this);
        }

    }
}
