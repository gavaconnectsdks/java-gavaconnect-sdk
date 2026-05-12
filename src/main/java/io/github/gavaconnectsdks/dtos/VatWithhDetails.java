package io.github.gavaconnectsdks.dtos;

import java.time.LocalDateTime;

import io.github.gavaconnectsdks.exceptions.BadRequestException;

public class VatWithhDetails {
    private String withholdeePin;
    private String invoiceNo;
    private LocalDateTime paymentDate;
    private float grossAmount;
    private float taxRate;
    private float taxAmount;
    
    
    private VatWithhDetails (Builder builder){
        this.grossAmount=builder.grossAmount;
        this.invoiceNo=builder.invoiceNo;
        this.paymentDate=builder.paymentDate;
        this.taxRate=builder.taxRate;
        this.withholdeePin=builder.withholdeePin;
        this.taxAmount=builder.taxAmount;
    }
    private static class Builder{
        private String withholdeePin;
        private String invoiceNo;
        private LocalDateTime paymentDate;
        private Float grossAmount;
        private Float taxRate;
        private Float taxAmount;

      
        public Builder grossAmount(float grossAmount) {
            this.grossAmount = grossAmount;
            return this;
        }
        public Builder invoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
            return this;
        }
        public Builder paymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
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
        public Builder withholdeePin(String withholdeePin) {
            this.withholdeePin = withholdeePin;
            return this;
        }

        public VatWithhDetails build(){
            if (this.invoiceNo==null) {
                throw  new BadRequestException("invoiceNo in vatWithhDetails is required");
            }
            if (this.paymentDate==null) {
                throw  new BadRequestException("paymentDate in vatWithhDetails  is required.");
            }
            if (this.grossAmount==null) {
                throw  new BadRequestException("grossAmount in vatWithhDetails  is required.");
            }
            if (this.taxRate==null) {
                throw new BadRequestException("taxRate in vatWithhDetails  is required.");
            }
            if (this.taxAmount==null) {
                throw new BadRequestException("taxAmount in vatWithhDetails  is required.");
            }
            return new VatWithhDetails(this);
        }

    }


     public static Builder builder(){
        return new Builder();
    }

    public float getGrossAmount() {
        return this.grossAmount;
    }
    public String getInvoiceNo() {
        return this.invoiceNo;
    }
    public LocalDateTime getPaymentDate() {
        return this.paymentDate;
    }
    public float getTaxAmount() {
        return this.taxAmount;
    }
    public float getTaxRate() {
        return this.taxRate;
    }
    public String getWithholdeePin() {
        return this.withholdeePin;
    }


}
