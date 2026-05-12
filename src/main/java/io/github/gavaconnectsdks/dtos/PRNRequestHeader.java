package io.github.gavaconnectsdks.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.gavaconnectsdks.exceptions.BadRequestException;
import io.github.gavaconnectsdks.utils.annotations.Pin;

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
            
            if (this.withholderPIN==null) {
                throw new BadRequestException("withholderPIN in PRNRequestHeader is required.");
            }
            if (this.noOfTransactions==null) {
                throw new BadRequestException("noOfTransactions in PRNRequestHeader is required.");
            }
            if (this.transactionUniqueNo==null) {
                throw  new BadRequestException("transactionUniqueNo in PRNRequestHeader is required.");
            }
            if (this.taxObligation==null) {
                throw  new BadRequestException("taxObligation in PRNRequestHeader is required.");
            }
            if (this.taxPeriodFrom==null) {
                throw  new BadRequestException("taxPeriodFrom in PRNRequestHeader is required.");
            }
            if (this.taxPeriodTo==null) {
                throw new BadRequestException("taxPeriodTo in PRNRequestHeader is required");
            }
            if (this.totalGrossAmount==null) {
                throw new BadRequestException("totalDrossAmount in PRNRequestHeader is required");
            }
            if (this.totalTaxAmount==null) {
                throw new BadRequestException("totalTaxAmount in PRNRequestHeader is required.");
            }

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
