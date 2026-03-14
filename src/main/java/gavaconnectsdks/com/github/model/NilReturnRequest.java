package gavaconnectsdks.com.github.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NilReturnRequest {

    @JsonProperty("TAXPAYERDETAILS")
    private NilReturnTaxPayerDetails taxPayerDetails;

    public NilReturnRequest(){}
    public NilReturnRequest(NilReturnTaxPayerDetails taxPayerDetails){
        this.taxPayerDetails=taxPayerDetails;
    }

    public NilReturnTaxPayerDetails getTaxPayerDetails() {
        return this.taxPayerDetails;
    }

    public void setTaxPayerDetails(NilReturnTaxPayerDetails taxPayerDetails) {
        this.taxPayerDetails = taxPayerDetails;
    }
}
