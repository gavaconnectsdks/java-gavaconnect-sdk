package io.github.gavaconnectsdks.dtos.requests;

import java.util.List;

import io.github.gavaconnectsdks.dtos.PRNRequestHeader;
import io.github.gavaconnectsdks.dtos.RentalIncomeWithhDetails;
import io.github.gavaconnectsdks.exceptions.ValidationException;

public class RentalIncomeWithhPRNRequest {
    private final PRNRequestHeader transactionHeader;
    private final List<RentalIncomeWithhDetails> transactionDetails;

    private RentalIncomeWithhPRNRequest(Builder builder){
        this.transactionDetails=builder.transactionDetails;
        this.transactionHeader=builder.transactionHeader;
    }

    private static class Builder{
        private PRNRequestHeader transactionHeader;
        private List<RentalIncomeWithhDetails> transactionDetails;

        public Builder TransactionDetails(List<RentalIncomeWithhDetails> transactionDetails) {
            this.transactionDetails = transactionDetails;
            return this;
        }

        public Builder TransactionHeader(PRNRequestHeader transactionHeader) {
            this.transactionHeader = transactionHeader;
            return this;
        }

        public RentalIncomeWithhPRNRequest build(){
            if (this.transactionHeader==null) {
                throw new ValidationException("transactionHeader is required.");
            }
            if(this.transactionDetails==null){
                throw new ValidationException("transactionDetails is required.");
            }
            return new RentalIncomeWithhPRNRequest(this);
        }
    }

    public List<RentalIncomeWithhDetails> getTransactionDetails() {
        return this.transactionDetails;
    }

    public PRNRequestHeader getTransactionHeader() {
        return this.transactionHeader;
    }

    
    public static Builder builder(){
        return new Builder();
    }
}
