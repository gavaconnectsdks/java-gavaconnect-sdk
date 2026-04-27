package gavaconnectsdks.com.github.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.utils.annotations.CustomPattern;
import gavaconnectsdks.com.github.utils.annotations.Pin;

public class ToTReturnsRequest {
    @Pin
    @JsonProperty("TaxpayerPIN")
    private final String taxpayerPIN;

    @CustomPattern(pattern="^\\d{2}$")
    @JsonProperty("Month")
    private final String month;

    @CustomPattern(pattern="^\\d{2}$")
    @JsonProperty("Year")
    private final String year;

    @JsonProperty("GrossTurnOver")
    private final float grossTurnOver;


    private ToTReturnsRequest(Builder builder){
        this.grossTurnOver=builder.grossTurnOver;
        this.month=builder.month;
        this.taxpayerPIN=builder.taxpayerPIN;
        this.year=builder.year;
    }

    private static class Builder{
        private String taxpayerPIN;

        private String month;

        private String year;

        private Float grossTurnOver;


        public Builder grossTurnOver(float grossTurnOver) {
            this.grossTurnOver = grossTurnOver;
            return this;
        }

        public Builder month(String month) {
            this.month = month;
            return this;
        }

        public Builder taxpayerPIN(String taxpayerPIN) {
            this.taxpayerPIN = taxpayerPIN;
            return this;
        }

        public Builder year(String year) {
            this.year = year;
            return this;
        }

        public ToTReturnsRequest build(){
            if (this.taxpayerPIN==null) {
                throw new  ValidationException("taxpayerPIN is required.");
            }
            if (this.month==null) {
                throw new ValidationException("month is required.");
            }
            if (this.year==null) {
                throw  new ValidationException("year is required.");
            }
            if (this.grossTurnOver==null) {
                throw new ValidationException("grossTurnOver is required.");
            }
            return new ToTReturnsRequest(this);
        }

    }

    public float getGrossTurnOver() {
        return this.grossTurnOver;
    }

    public String getMonth() {
        return this.month;
    }

    public String getTaxpayerPIN() {
        return this.taxpayerPIN;
    }

    public String getYear() {
        return this.year;
    }

    public Builder builder(){
        return new Builder();
    }

}
