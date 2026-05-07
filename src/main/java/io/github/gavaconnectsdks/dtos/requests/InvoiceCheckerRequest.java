package io.github.gavaconnectsdks.dtos.requests;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.gavaconnectsdks.exceptions.ValidationException;

public class InvoiceCheckerRequest {
    private final String invoiceNumber;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private final LocalDate invoiceDate;

    private InvoiceCheckerRequest(Builder builder){
        this.invoiceDate=builder.invoicedDate;
        this.invoiceNumber=builder.invoiceNumber;
    }

    public static class Builder{
        private String invoiceNumber;
        private LocalDate invoicedDate;

        public Builder invoicedDate(LocalDate invoicedDate) {
            this.invoicedDate = invoicedDate;
            return this;
        }

        public Builder invoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return  this;
        }
        public InvoiceCheckerRequest build(){
            if(this.invoiceNumber==null){
                throw new ValidationException("invoiceNumber is required");
            }
            if(this.invoicedDate==null){
                throw new ValidationException("invoiceDate is required");
            }
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
