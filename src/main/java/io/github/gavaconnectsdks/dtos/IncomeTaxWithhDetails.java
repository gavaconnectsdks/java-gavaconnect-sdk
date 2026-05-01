package io.github.gavaconnectsdks.dtos;

import java.time.LocalDateTime;

import io.github.gavaconnectsdks.exceptions.ValidationException;
import io.github.gavaconnectsdks.utils.annotations.Pin;

public class IncomeTaxWithhDetails {
    private String natureOfTransaction;
    private String residentialStatus;
    private String country;
    private LocalDateTime paymentDate;

    @Pin
    private String withholdeePin;
    private String invoiceNo;
    private LocalDateTime invoiceDate;
    private float grossAmount;
    private float taxRate;
    private float taxAmount;
    private String withholdeeName;
    private String withholdeeEmail;
    private String withholdeeAddress;

    private IncomeTaxWithhDetails(Builder builder){
        this.natureOfTransaction=builder.natureOfTransaction;
        this.residentialStatus=builder.residentialStatus;
        this.country=builder.country;
        this.paymentDate=builder.paymentDate;
        this.withholdeePin=builder.withholdeePin;
        this.invoiceNo=builder.invoiceNo;
        this.invoiceDate=builder.invoiceDate;
        this.grossAmount=builder.grossAmount;
        this.taxRate=builder.taxRate;
        this.taxAmount=builder.taxAmount;
        this.withholdeeName=builder.withholdeeName;
        this.withholdeeEmail=builder.withholdeeEmail;
        this.withholdeeAddress=builder.withholdeeAddress;
    }
    private static class Builder{
        private String natureOfTransaction;
        private String residentialStatus;
        private String country;
        private LocalDateTime paymentDate;
        private String withholdeePin;
        private String invoiceNo;
        private LocalDateTime invoiceDate;
        private Float grossAmount;
        private Float taxRate;
        private Float taxAmount;
        private String withholdeeName;
        private String withholdeeEmail;
        private String withholdeeAddress;

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder grossAmount(float grossAmount) {
            this.grossAmount = grossAmount;
            return this;
        }

        public Builder invoiceDate(LocalDateTime invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder invoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
            return this;
        }

        public Builder natureOfTransaction(String natureOfTransaction) {
            this.natureOfTransaction = natureOfTransaction;
            return this;
        }

        public Builder paymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder residentialStatus(String residentialStatus) {
            this.residentialStatus = residentialStatus;
            return this;
        }

        public Builder taxAmount(float taxAmount) {
            this.taxAmount = taxAmount;
            return this;
        }

        public Builder taxRate(float taxRate) {
            this.taxRate = taxRate;
            return this;
        }

        public Builder withholdeeAddress(String withholdeeAddress) {
            this.withholdeeAddress = withholdeeAddress;
            return this;
        }

        public Builder withholdeeEmail(String withholdeeEmail) {
            this.withholdeeEmail = withholdeeEmail;
            return this;
        }

        public Builder withholdeeName(String withholdeeName) {
            this.withholdeeName = withholdeeName;
            return this;
        }

        public Builder withholdeePin(String withholdeePin) {
            this.withholdeePin = withholdeePin;
            return this;
        }

        public IncomeTaxWithhDetails build(){
            if (this.natureOfTransaction==null) {
                throw new ValidationException("natureOfTransaction in IncomeTaxWithhDetails is required");
            }
            if (this.residentialStatus==null) {
                throw new ValidationException("residentialStatus in IncomeTaxWithhDetails is required.");
            }
            if (this.country==null) {
                throw  new ValidationException("country in IncomeTaxWithhDetails is required.");
            }
            if (this.paymentDate==null) {
                throw new ValidationException("paymentDate in IncomeTaxWithhDetails is required.");
            }
            if (this.withholdeePin==null) {
                throw new ValidationException("withholdeePin in IncomeTaxWithhDetails is required.");
            }
            if (this.invoiceNo==null) {
                throw new ValidationException("invoiceNo in IncomeTaxWithhDetails is required.");
            }

            if(this.invoiceDate==null){
                throw new ValidationException("invoiceDate in IncomeTaxWithhDetails is required.");
            }

            if(this.grossAmount==null){
                throw new ValidationException("grossAmount in IncomeTaxWithhDetails is required.");
            }

            if (this.taxAmount==null) {
                throw new ValidationException("taxAmount in IncomeTaxWithhDetails is required.");
            }

            if (this.withholdeeName==null) {
                throw  new ValidationException("withholdeeName in IncomeTaxWithhDetails is required.");
            }

            if (this.withholdeeEmail==null) {
                throw new ValidationException("withholdeeEmail in IncomeTaxWithhDetails is required.");
            }

            if (this.withholdeeAddress==null) {
                throw new ValidationException("withholdeeAddress in IncomeTaxWithhDetails is required.");
            }
            
            return new IncomeTaxWithhDetails(this);
        }

    }
    public String getCountry() {
        return this.country;
    }

    public float getGrossAmount() {
        return this.grossAmount;
    }

    public LocalDateTime getInvoiceDate() {
        return this.invoiceDate;
    }

    public String getInvoiceNo() {
        return this.invoiceNo;
    }

    public String getNatureOfTransaction() {
        return this.natureOfTransaction;
    }

    public LocalDateTime getPaymentDate() {
        return this.paymentDate;
    }

    public String getResidentialStatus() {
        return this.residentialStatus;
    }

    public float getTaxAmount() {
        return this.taxAmount;
    }

    public float getTaxRate() {
        return this.taxRate;
    }

    public String getWithholdeeAddress() {
        return this.withholdeeAddress;
    }

    public String getWithholdeeEmail() {
        return this.withholdeeEmail;
    }

    public String getWithholdeeName() {
        return this.withholdeeName;
    }

    public String getWithholdeePin() {
        return this.withholdeePin;
    }

    public static Builder builder(){
        return new Builder();
    }
}
