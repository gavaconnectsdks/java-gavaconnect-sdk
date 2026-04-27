package gavaconnectsdks.com.github.dtos.requests;

import java.util.List;

import gavaconnectsdks.com.github.dtos.PRNRequestHeader;
import gavaconnectsdks.com.github.dtos.RentalIncomeWithhDetails;

public class RentalIncomeWithhPRNRequest {
    private final PRNRequestHeader transactionHeader;
    private final List<RentalIncomeWithhDetails> transactionDetails;

    private RentalIncomeWithhPRNRequest(Builder builder){
        this.transactionDetails=builder.transactionDetails;
        this.transactionHeader=builder.transactionHeader;
    }

    private static class Builder{
        PRNRequestHeader transactionHeader;
        List<RentalIncomeWithhDetails> transactionDetails;

        public Builder TransactionDetails(List<RentalIncomeWithhDetails> transactionDetails) {
            this.transactionDetails = transactionDetails;
            return this;
        }

        public Builder TransactionHeader(PRNRequestHeader transactionHeader) {
            this.transactionHeader = transactionHeader;
            return this;
        }

        public RentalIncomeWithhPRNRequest build(){
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
