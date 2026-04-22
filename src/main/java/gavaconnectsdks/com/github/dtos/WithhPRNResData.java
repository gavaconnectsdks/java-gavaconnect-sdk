package gavaconnectsdks.com.github.dtos;

import java.time.LocalDateTime;

public class WithhPRNResData {
    private String prnNumber;
    private LocalDateTime prnDate;
    private float amount;

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setPrnDate(LocalDateTime prnDate) {
        this.prnDate = prnDate;
    }

    public void setPrnNumber(String prnNumber) {
        this.prnNumber = prnNumber;
    }

    public float getAmount() {
        return this.amount;
    }

    public LocalDateTime getPrnDate() {
        return this.prnDate;
    }

    public String getPrnNumber() {
        return this.prnNumber;
    }

    
}
