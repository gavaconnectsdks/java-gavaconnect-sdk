package io.github.gavaconnectsdks.dtos;



import io.github.gavaconnectsdks.utils.annotations.CustomPattern;
import io.github.gavaconnectsdks.utils.annotations.ObligationCode;
import io.github.gavaconnectsdks.utils.annotations.Pin;

public class NilReturnTaxPayerDetails {

    @Pin
    private String TaxPayerPIN;

    @CustomPattern(pattern="^\\d{2}$")
    private String Month;

    @CustomPattern(pattern="^\\d{4}$")
    private String Year;

    @ObligationCode
    private String  ObligationCode;

    public NilReturnTaxPayerDetails(){}

    private NilReturnTaxPayerDetails(Builder builder){
        this.ObligationCode=builder.ObligationCode;
        this.Month=builder.Month;
        this.TaxPayerPIN=builder.TaxPayerPIN;
        this.Year=builder.Year;
    }



    private static class Builder{

    @Pin
    private String TaxPayerPIN;

    @CustomPattern(pattern="^\\d{2}$")
    private String Month;

    @CustomPattern(pattern="^\\d{4}$")
    private String Year;

    @ObligationCode
    private String  ObligationCode;
    
    public Builder(){}
        public Builder ObligationCode(String ObligationCode) {
        this.ObligationCode = ObligationCode;
        return  this;
    }

    public Builder Month(String Month) {
        this.Month = Month;
        return this;
    }

    public Builder TaxPayerPIN(String TaxPayerPIN) {
        this.TaxPayerPIN = TaxPayerPIN;
        return this;
    }

    public Builder Year(String Year) {
        this.Year = Year;
        return this;
    }
    public NilReturnTaxPayerDetails build(){
        return new NilReturnTaxPayerDetails(this);
    }

    }

    public String getObligationCode() {
        return this.ObligationCode;
    }

    public String getMonth() {
        return this.Month;
    }

    public String getTaxPayerPIN() {
        return this.TaxPayerPIN;
    }

    public String getYear() {
        return this.Year;
    }


       
    private static Builder builder(){
        return new Builder();

    }

}
