package io.github.gavaconnectsdks.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TCCData {
    @JsonProperty("KRAPIN")
    private String kraPIN;
    @JsonProperty("TCCNumber")
    private String taxComplianceCertificateNumber;
    @JsonProperty("TCCStatus")
    private String taxComplianceCertificateStatus;
    @JsonProperty("TCCIssueDate")
    private LocalDate taxComplianceCertificateIssueDate;

    @JsonProperty("TCCExpiryDate")
    private LocalDate taxComplianceCertificateExpiryDate;

    public String getKraPIN() {
        return this.kraPIN;
    }

    public LocalDate getTaxComplianceCertificateIssueDate() {
        return this.taxComplianceCertificateIssueDate;
    }

    public LocalDate getTaxComplianceCertificateExpiryDate() {
        return this.taxComplianceCertificateExpiryDate;
    }

    public String getTaxComplianceCertificateNumber() {
        return this.taxComplianceCertificateNumber;
    }

    public String getTaxComplianceCertificateStatus() {
        return this.taxComplianceCertificateStatus;
    }

    public void setKraPIN(String kraPIN) {
        this.kraPIN = kraPIN;
    }

    public void setTaxComplianceCertificateIssueDate(LocalDate taxComplianceCertificateIssueDate) {
        this.taxComplianceCertificateIssueDate = taxComplianceCertificateIssueDate;
    }

    public void setTaxComplianceCertificateNumber(String taxComplianceCertificateNumber) {
        this.taxComplianceCertificateNumber = taxComplianceCertificateNumber;
    }

    public void setTaxComplianceCertificateStatus(String taxComplianceCertificateStatus) {
        this.taxComplianceCertificateStatus = taxComplianceCertificateStatus;
    }

    public void setTaxComplianceCertificateExpiryDate(LocalDate taxComplianceCertificateExpiryDate) {
        this.taxComplianceCertificateExpiryDate = taxComplianceCertificateExpiryDate;
    }
    
}
