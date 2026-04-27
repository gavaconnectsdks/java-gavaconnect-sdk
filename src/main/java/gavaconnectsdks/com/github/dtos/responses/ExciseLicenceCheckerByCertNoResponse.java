package gavaconnectsdks.com.github.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.dtos.ExciseLicenseDetail2;

public class ExciseLicenceCheckerByCertNoResponse {
    @JsonProperty(value="Status")
    private String status;

    @JsonProperty(value="ResponseCode")
    private String responseCode;

    @JsonProperty(value="Message")
    private String message;

    @JsonProperty(value="ExciseLicenseDATA")
    private ExciseLicenseDetail2 exciseLicenseDetail;


    public void setExciseLicenseDetails(ExciseLicenseDetail2 exciseLicenseDetail) {
        this.exciseLicenseDetail = exciseLicenseDetail;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ExciseLicenseDetail2 getExciseLicenseDetails() {
        return this.exciseLicenseDetail;
    }

    public String getMessage() {
        return this.message;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getStatus() {
        return this.status;
    }
   
}
