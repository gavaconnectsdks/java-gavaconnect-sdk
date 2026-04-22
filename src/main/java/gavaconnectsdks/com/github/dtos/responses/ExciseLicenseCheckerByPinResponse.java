package gavaconnectsdks.com.github.dtos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.dtos.ExciseLicenseDetail;
import gavaconnectsdks.com.github.dtos.ImportCertDetail;
import gavaconnectsdks.com.github.dtos.PinDetail;

public class ExciseLicenseCheckerByPinResponse {
    @JsonProperty(value="Status")
    private String status;

    @JsonProperty(value="ResponseCode")
    private String responseCode;

    @JsonProperty(value="Message")
    private String message;

    @JsonProperty(value="PIN_DETAILS")
    private List<PinDetail> pinDetails;

    @JsonProperty(value="ExciseLicenseDetails")
    private List<ExciseLicenseDetail> exciseLicenseDetails;

    @JsonProperty(value="ImportCertificateDetails")
    private List<ImportCertDetail> importCertificateDetails;

    public void setExciseLicenseDetails(List<ExciseLicenseDetail> exciseLicenseDetails) {
        this.exciseLicenseDetails = exciseLicenseDetails;
    }

    public void setImportCertificateDetails(List<ImportCertDetail> importCertificateDetails) {
        this.importCertificateDetails = importCertificateDetails;
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

    public List<ExciseLicenseDetail> getExciseLicenseDetails() {
        return this.exciseLicenseDetails;
    }

    public List<ImportCertDetail> getImportCertificateDetails() {
        return this.importCertificateDetails;
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
