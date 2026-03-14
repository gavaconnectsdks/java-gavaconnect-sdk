package gavaconnectsdks.com.github.model;



import gavaconnectsdks.com.github.utils.annotations.Pin;

public class NilReturnTaxPayerDetails {

    @Pin
    private String TaxPayerPIN;

    private String Month;

    private String Year;

    private float  GrossTurnover;

    public NilReturnTaxPayerDetails(){}

    private NilReturnTaxPayerDetails(Builder builder){
        this.GrossTurnover=builder.GrossTurnover;
        this.Month=builder.Month;
        this.TaxPayerPIN=builder.TaxPayerPIN;
        this.Year=builder.Year;
    }



    private static class Builder{

    @Pin
    private String TaxPayerPIN;

    private String Month;

    private String Year;

    private float  GrossTurnover;
    
    public Builder(){}
        public Builder GrossTurnover(float GrossTurnover) {
        this.GrossTurnover = GrossTurnover;
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

    public float getGrossTurnover() {
        return GrossTurnover;
    }

    public String getMonth() {
        return Month;
    }

    public String getTaxPayerPIN() {
        return TaxPayerPIN;
    }

    public String getYear() {
        return Year;
    }


       
    private static Builder builder(){
        return new Builder();

    }

}
