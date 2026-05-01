package io.github.gavaconnectsdks.dtos;

import  java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImportCertdetails {
    @JsonProperty("taxPayerName")
    private String taxpayerName;
    private String pinNo;

    @JsonProperty("importCertDtls")
    private List<ImportCertDetail> importCertificateDetails;

    public void setImportCertificateDetails(List<ImportCertDetail> importCertificateDetails) {
        this.importCertificateDetails = importCertificateDetails;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
    }

    public void setTaxpayerName(String taxpayerName) {
        this.taxpayerName = taxpayerName;
    }

    public List<ImportCertDetail> getImportCertificateDetails() {
        return this.importCertificateDetails;
    }

    public String getPinNo() {
        return this.pinNo;
    }

    public String getTaxpayerName() {
        return this.taxpayerName;
    }

    
}
