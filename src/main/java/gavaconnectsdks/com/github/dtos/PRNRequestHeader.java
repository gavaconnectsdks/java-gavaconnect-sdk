package gavaconnectsdks.com.github.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import gavaconnectsdks.com.github.utils.annotations.Pin;

public class PRNRequestHeader {
    @Pin
    String withholderPIN;
    String transactionUniqueNo;
    Integer noOfTransactions;
    String taxObligation;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime taxPeriodFrom;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime taxPeriodTo;
    Float totalGrossAmount;
    Float totalTaxAmount;

    private PRNRequestHeader(Builder builder){
        this.withholderPIN=builder.withholderPIN;
        this.transactionUniqueNo=builder.transactionUniqueNo;
        this.noOfTransactions=builder.noOfTransactions;
        this.taxObligation=builder.taxObligation;
        this.taxPeriodFrom=builder.taxPeriodFrom;
        this.taxPeriodTo=builder.taxPeriodTo;
        this.totalGrossAmount=builder.totalGrossAmount;
        this.totalTaxAmount=builder.totalTaxAmount;
    }
    private static class Builder{
        String withholderPIN;
        String transactionUniqueNo;
        Integer noOfTransactions;
        String taxObligation;
        LocalDateTime taxPeriodFrom;
        LocalDateTime taxPeriodTo;
        Float totalGrossAmount;
        Float totalTaxAmount;

        public Builder noOfTransactions(Integer noOfTransactions) {
            this.noOfTransactions = noOfTransactions;
            return this;
        }

        public Builder taxObligation(String taxObligation) {
            this.taxObligation = taxObligation;
            return this;
        }

        public Builder taxPeriodFrom(LocalDateTime taxPeriodFrom) {
            this.taxPeriodFrom = taxPeriodFrom;
            return this;
        }

        public Builder taxPeriodTo(LocalDateTime taxPeriodTo) {
            this.taxPeriodTo = taxPeriodTo;
            return this;
        }

        public Builder totalGrossAmount(Float totalGrossAmount) {
            this.totalGrossAmount = totalGrossAmount;
            return this;
        }

        public Builder totalTaxAmount(Float totalTaxAmount) {
            this.totalTaxAmount = totalTaxAmount;
            return  this;
        }

        public Builder transactionUniqueNo(String transactionUniqueNo) {
            this.transactionUniqueNo = transactionUniqueNo;
            return this;
        }

        public Builder withholderPIN(String withholderPIN) {
            this.withholderPIN = withholderPIN;
            return this;
        }

        public PRNRequestHeader build(){
            return new PRNRequestHeader(this);
        }
        

    }

    public Integer getNoOfTransactions() {
        return this.noOfTransactions;
    }

    public String getTaxObligation() {
        return this.taxObligation;
    }

    public LocalDateTime getTaxPeriodFrom() {
        return this.taxPeriodFrom;
    }

    public LocalDateTime getTaxPeriodTo() {
        return this.taxPeriodTo;
    }

    public Float getTotalGrossAmount() {
        return this.totalGrossAmount;
    }

    public Float getTotalTaxAmount() {
        return this.totalTaxAmount;
    }

    public String getTransactionUniqueNo() {
        return this.transactionUniqueNo;
    }

    public String getWithholderPIN() {
        return this.withholderPIN;
    }
    
    public static Builder builder(){
        return new Builder();
    }
}
