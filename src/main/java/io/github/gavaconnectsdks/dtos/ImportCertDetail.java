package io.github.gavaconnectsdks.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImportCertDetail {
    @JsonProperty(value="certiNo")
    private String certificateNumber;

    @JsonProperty(value="issueDt")
    private String issueDate;

    private String statusFlag;

    private String productCode;

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setStatusFlag(String statusFlag) {
        this.statusFlag = statusFlag;
    }

    public String getCertificateNumber() {
        return this.certificateNumber;
    }

    public String getIssueDate() {
        return this.issueDate;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getStatusFlag() {
        return this.statusFlag;
    }

}
