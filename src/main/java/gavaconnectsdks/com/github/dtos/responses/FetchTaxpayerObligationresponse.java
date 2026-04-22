package gavaconnectsdks.com.github.dtos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.dtos.Obligation;

public class FetchTaxpayerObligationresponse {
    @JsonProperty(value="ResponseCode")
    private String responseCode;

    @JsonProperty(value="ResponseMsg")
    private  String responseMessage;

    @JsonProperty(value="Status")
    private String status;

    @JsonProperty(value="ObligationsList")
    private List<Obligation> obligations;

    public void setObligations(List<Obligation> obligations) {
        this.obligations = obligations;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Obligation> getObligations() {
        return this.obligations;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public String getStatus() {
        return this.status;
    }

}
