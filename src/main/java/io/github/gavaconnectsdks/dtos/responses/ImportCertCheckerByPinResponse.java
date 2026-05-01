package io.github.gavaconnectsdks.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.gavaconnectsdks.dtos.ImportCertdetails;

public class ImportCertCheckerByPinResponse {
     @JsonProperty(value="response_message")
    private String responseMessage;

    @JsonProperty(value="response_code")
    private String responseCode;

    @JsonProperty(value="response_status")
    private  String responseStatus;

    @JsonProperty(value="importCertificateDetails")
    private ImportCertdetails importCertificateDetails;

    public void setImportCertificateDetails(ImportCertdetails importCertificateDetails) {
        this.importCertificateDetails = importCertificateDetails;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public ImportCertdetails getImportCertificateDetails() {
        return this.importCertificateDetails;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public String getResponseStatus() {
        return this.responseStatus;
    }   
}
