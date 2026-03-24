package gavaconnectsdks.com.github.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class VatExcemptionCertificateDetail {
    @JsonProperty(value="certiNo")
    private String certificateNumber;
    @JsonProperty(value="issueDt")
    private String issueDate;
    private  String statusFlag;

    private VatExcemptionCertificateDetail(Builder builder){
        this.certificateNumber=builder.certificateNumber;
        this.issueDate=builder.issueDate;
        this.statusFlag=builder.statusFlag;
    }

    private static class Builder{
        private String certificateNumber;
        private String issueDate;
        private  String statusFlag;

        public Builder CertificateNumber(String certificateNumber) {
            this.certificateNumber = certificateNumber;
            return this;
        }

        public Builder IssueDate(String issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder StatusFlag(String statusFlag) {
            this.statusFlag = statusFlag;
            return this;
        }

        public VatExcemptionCertificateDetail build(){
            return new VatExcemptionCertificateDetail(this);
        }

    }

    public String getCertificateNumber() {
        return this.certificateNumber;
    }

    public String getIssueDate() {
        return this.issueDate;
    }

    public String getStatusFlag() {
        return this.statusFlag;
    }
    public static Builder builder(){
        return new Builder();
    }
}
