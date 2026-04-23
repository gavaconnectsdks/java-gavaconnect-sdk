package gavaconnectsdks.com.github.dtos.responses;

import gavaconnectsdks.com.github.dtos.InvoiceDetail;

public class InvoiceCheckerResponse {
    private String responseCode;
    private String responseDesc;
    private String status;
    private InvoiceDetail invoiceDetails;

    public InvoiceDetail getInvoiceDetails() {
        return this.invoiceDetails;
    }
    public String getResponseCode() {
        return this.responseCode;
    }

    public String getResponseDesc() {
        return this.responseDesc;
    }

    public void setInvoiceDetails(InvoiceDetail invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    
    
}
