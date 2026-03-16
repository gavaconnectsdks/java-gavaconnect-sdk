package gavaconnectsdks.com.github.model;

import java.time.LocalDateTime;

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
        private float grossAmount;
        private float taxRate;
        private float taxAmount;

      
        public Builder GrossAmount(float grossAmount) {
            this.grossAmount = grossAmount;
            return this;
        }
        public Builder InvoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
            return this;
        }
        public Builder PaymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }
        public Builder TaxAmount(float taxAmount) {
            this.taxAmount = taxAmount;
            return this;
        }
        public Builder TaxRate(float taxRate) {
            this.taxRate = taxRate;
            return this;
        }
        public Builder WithholdeePin(String withholdeePin) {
            this.withholdeePin = withholdeePin;
            return this;
        }

        public VatWithhDetails build(){
            return new VatWithhDetails(this);
        }

    }


     public Builder builder(){
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
