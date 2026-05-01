package io.github.gavaconnectsdks.dtos.responses;

import io.github.gavaconnectsdks.dtos.WithhPRNResData;

public class WithholdingPRNResponse {
    private String responseCode;
    private String responseDesc;
    private String status;
    private WithhPRNResData responseData;

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseData(WithhPRNResData responseData) {
        this.responseData = responseData;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public WithhPRNResData getResponseData() {
        return this.responseData;
    }

    public String getResponseDesc() {
        return this.responseDesc;
    }

    public String getStatus() {
        return this.status;
    }

    

}
