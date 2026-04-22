package gavaconnectsdks.com.github.dtos;

import java.time.LocalDate;

public class TCCData {
    private String KRAPIN;
    private String TCCNumber;
    private String TCCStatus;
    private LocalDate TCCIssueDate;
    private LocalDate TCCExpiryDate;

    public String getKRAPIN() {
        return this.KRAPIN;
    }

    public LocalDate getTCCExpiryDate() {
        return this.TCCExpiryDate;
    }

    public LocalDate getTCCIssueDate() {
        return this.TCCIssueDate;
    }

    public String getTCCNumber() {
        return this.TCCNumber;
    }

    public String getTCCStatus() {
        return this.TCCStatus;
    }

    public void setKRAPIN(String KRAPIN) {
        this.KRAPIN = KRAPIN;
    }

    public void setTCCExpiryDate(LocalDate TCCExpiryDate) {
        this.TCCExpiryDate = TCCExpiryDate;
    }

    public void setTCCIssueDate(LocalDate TCCIssueDate) {
        this.TCCIssueDate = TCCIssueDate;
    }

    public void setTCCNumber(String TCCNumber) {
        this.TCCNumber = TCCNumber;
    }

    public void setTCCStatus(String TCCStatus) {
        this.TCCStatus = TCCStatus;
    }
    
    
    
}
