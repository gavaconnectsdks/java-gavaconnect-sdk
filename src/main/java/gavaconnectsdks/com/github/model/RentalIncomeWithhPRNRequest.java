package gavaconnectsdks.com.github.model;

public class RentalIncomeWithhPRNRequest {
    private PRNRequestHeader transactionHeader;
    private RentalIncomeWithhDetails transactionDetails;

    private RentalIncomeWithhPRNRequest(Builder builder){
        this.transactionDetails=builder.transactionDetails;
        this.transactionHeader=builder.transactionHeader;
    }

    private static class Builder{
        PRNRequestHeader transactionHeader;
        RentalIncomeWithhDetails transactionDetails;

        public Builder TransactionDetails(RentalIncomeWithhDetails transactionDetails) {
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

    public RentalIncomeWithhDetails getTransactionDetails() {
        return this.transactionDetails;
    }

    public PRNRequestHeader getTransactionHeader() {
        return this.transactionHeader;
    }

    
    public Builder builder(){
        return new Builder();
    }
}
