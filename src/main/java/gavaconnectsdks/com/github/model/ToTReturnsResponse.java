package gavaconnectsdks.com.github.model;

public class ToTReturnsResponse {
    private String RespondeCode;
    private String Message;
    private String Status;
    private String AckNumber;
    private String PRN;
    private Float ComputedTax;
    private Float UtilizedCredit;
    private Float TaxPayable;

    public void setAckNumber(String AckNumber) {
        this.AckNumber = AckNumber;
    }

    public void setComputedTax(Float ComputedTax) {
        this.ComputedTax = ComputedTax;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void setPRN(String PRN) {
        this.PRN = PRN;
    }

    public void setRespondeCode(String RespondeCode) {
        this.RespondeCode = RespondeCode;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setTaxPayable(Float TaxPayable) {
        this.TaxPayable = TaxPayable;
    }

    public void setUtilizedCredit(Float UtilizedCredit) {
        this.UtilizedCredit = UtilizedCredit;
    }

    public String getAckNumber() {
        return this.AckNumber;
    }

    public Float getComputedTax() {
        return this.ComputedTax;
    }
    
    public String getMessage() {
        return this.Message;
    }

    public String getPRN() {
        return this.PRN;
    }

    public String getRespondeCode() {
        return this.RespondeCode;
    }

    public String getStatus() {
        return this.Status;
    }

    public Float getTaxPayable() {
        return this.TaxPayable;
    }

    public Float getUtilizedCredit() {
        return this.UtilizedCredit;
    }
    
}
