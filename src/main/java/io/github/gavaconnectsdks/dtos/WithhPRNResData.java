package io.github.gavaconnectsdks.dtos;

import java.time.LocalDateTime;

public class WithhPRNResData {
    private String prnNumber;
    private LocalDateTime prnDate;
    private float prnAmount;

    public void setPrnAmount(float amount) {
        this.prnAmount = amount;
    }

    public void setPrnDate(LocalDateTime prnDate) {
        this.prnDate = prnDate;
    }

    public void setPrnNumber(String prnNumber) {
        this.prnNumber = prnNumber;
    }

    public float getPrnAmount() {
        return this.prnAmount;
    }

    public LocalDateTime getPrnDate() {
        return this.prnDate;
    }

    public String getPrnNumber() {
        return this.prnNumber;
    }

    
}
