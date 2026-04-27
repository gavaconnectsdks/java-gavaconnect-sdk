package gavaconnectsdks.com.github.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.utils.annotations.CustomPattern;
import gavaconnectsdks.com.github.utils.annotations.ObligationCode;
import gavaconnectsdks.com.github.utils.annotations.Pin;
import gavaconnectsdks.com.github.utils.enums.ObligationCodeEnum;

public class NilReturnRequest {

    @Pin(message="Invalid TaxPayerPin")
    @JsonProperty("TaxpayerPIN")
    private final  String taxpayerPIN;

    @JsonProperty("ObligationCode")
    @ObligationCode(message="Invalid ObligationCode")
    private final String obligationCode;


    @CustomPattern(pattern="^\\d{2}$")
    @JsonProperty("Month")
    private final String month;
    
    @CustomPattern(pattern="^\\d{4}$")
    @JsonProperty("Year")
    private final String year;


    private NilReturnRequest(Builder builder){
        this.month=builder.month;
        this.obligationCode= String.valueOf(builder.obligationCode.getCode());
        this.taxpayerPIN=builder.taxpayerPIN;
        this.year=builder.year;
    }
    
    private static class Builder{

    private String taxpayerPIN;

    
    private ObligationCodeEnum obligationCode;

    private String month;
    
    private String year;

        public Builder month(String month) {
            this.month = month;
            return this;
        }

        public Builder obligationCode(ObligationCodeEnum obligationCode) {
            this.obligationCode = obligationCode;
            return this;
        }

        public Builder taxPayerPIN(String taxPayerPIN) {
            this.taxpayerPIN = taxPayerPIN;
            return this;
        }

        public Builder year(String year) {
            this.year = year;
            return  this;
        }

        public NilReturnRequest build(){
            return  new NilReturnRequest(this);
        }
    }

    public String getMonth() {
        return this.month;
    }

    public String getObligationCode() {
        return this.obligationCode;
    }

    public String getTaxPayerPIN() {
        return this.taxpayerPIN;
    }

    public String getYear() {
        return this.year;
    }

    public static Builder builder(){
        return new Builder();
    }
    
}
