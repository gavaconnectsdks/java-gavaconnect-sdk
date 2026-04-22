package gavaconnectsdks.com.github.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxpayerDetailsWrapper<T> {
    @JsonProperty("TAXPAYERDETAILS")
    private T taxpayerDetails;

    public TaxpayerDetailsWrapper(T taxpayerDetails){
        this.taxpayerDetails=taxpayerDetails;
    }

    public T getTaxpayerDetails() {
        return this.taxpayerDetails;
    }

}
