package gavaconnectsdks.com.github.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExciseLinenceCheckerByCertNoresponse {
    @JsonProperty(value="Status")
    private String status;

    @JsonProperty(value="ResponseCode")
    private String responseCode;

    @JsonProperty(value="Message")
    private String message;

    @JsonProperty(value="PIN_DETAILS")
    private List<PinDetail> pinDetails;

    @JsonProperty(value="ExciseLicenseDetails")
    private ExciseLicenseDetail exciseLicenseDetail;


    public void setExciseLicenseDetails(ExciseLicenseDetail exciseLicenseDetail) {
        this.exciseLicenseDetail = exciseLicenseDetail;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPinDetails(List<PinDetail> pinDetails) {
        this.pinDetails = pinDetails;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ExciseLicenseDetail getExciseLicenseDetails() {
        return this.exciseLicenseDetail;
    }

    public String getMessage() {
        return this.message;
    }

    public List<PinDetail> getPinDetails() {
        return this.pinDetails;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getStatus() {
        return this.status;
    }
   
}
