package gavaconnectsdks.com.github.model;

import java.time.LocalDate;

public class InvoiceCheckerRequest {
    private String invoiceNumber;
    private LocalDate invoiceDate;

    private InvoiceCheckerRequest(Builder builder){
        this.invoiceDate=builder.invoicedDate;
        this.invoiceNumber=builder.invoiceNumber;
    }

    private static class Builder{
        private String invoiceNumber;
        private LocalDate invoicedDate;

        public Builder InvoicedDate(LocalDate invoicedDate) {
            this.invoicedDate = invoicedDate;
            return this;
        }

        public Builder InvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return  this;
        }
        public InvoiceCheckerRequest build(){
            return  new InvoiceCheckerRequest(this);
        }
    }

    public LocalDate getInvoiceDate() {
        return this.invoiceDate;
    }

    public String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    public static Builder builder(){
        return  new Builder();
    }
    
}
