package gavaconnectsdks.com.github.model;

import gavaconnectsdks.com.github.utils.annotations.CustomPattern;
import gavaconnectsdks.com.github.utils.annotations.ObligationCode;
import gavaconnectsdks.com.github.utils.annotations.Pin;

public class NilReturnRequest {

    @Pin(message="Invalid TaxPayerPin")
    private String TaxPayerPIN;

    @ObligationCode(message="Invalid ObligationCode")
    private String ObligationCode;

    @CustomPattern(pattern="^\\d{2}")
    private String Month;
    
    @CustomPattern(pattern="^\\d{4}")
    private String Year;


    private NilReturnRequest(Builder builder){
        this.Month=builder.Month;
        this.ObligationCode=builder.ObligationCode;
        this.TaxPayerPIN=builder.TaxPayerPIN;
        this.Year=builder.Year;
    }
    
    private static class Builder{

    @Pin(message="Invalid TaxPayerPin")
    private String TaxPayerPIN;

    @ObligationCode(message="Invalid ObligationCode")
    private String ObligationCode;

    @CustomPattern(pattern="^\\d{2}")
    private String Month;
    
    @CustomPattern(pattern="^\\d{4}")
    private String Year;

        public Builder Month(String Month) {
            this.Month = Month;
            return this;
        }

        public Builder ObligationCode(String ObligationCode) {
            this.ObligationCode = ObligationCode;
            return this;
        }

        public Builder TaxPayerPIN(String TaxPayerPIN) {
            this.TaxPayerPIN = TaxPayerPIN;
            return this;
        }

        public Builder Year(String Year) {
            this.Year = Year;
            return  this;
        }

        public NilReturnRequest build(){
            return  new NilReturnRequest(this);
        }
    }

    public String getMonth() {
        return this.Month;
    }

    public String getObligationCode() {
        return this.ObligationCode;
    }

    public String getTaxPayerPIN() {
        return this.TaxPayerPIN;
    }

    public String getYear() {
        return this.Year;
    }

    public static Builder builder(){
        return new Builder();
    }
    
}
