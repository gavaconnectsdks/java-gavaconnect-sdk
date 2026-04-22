package gavaconnectsdks.com.github.dtos;

import java.time.LocalDateTime;

import gavaconnectsdks.com.github.utils.annotations.Pin;

public class PRNRequestHeader {
    @Pin
    String withholderPIN;
    String transactionUniqueNo;
    int noOfTransactions;
    String taxObligation;
    LocalDateTime taxPeriodFrom;
    LocalDateTime taxPeriodTo;
    Float totalGrossAmount;
    Float totalTaxAmount;
}
