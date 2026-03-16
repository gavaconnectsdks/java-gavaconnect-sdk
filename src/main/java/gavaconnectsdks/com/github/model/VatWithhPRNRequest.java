package gavaconnectsdks.com.github.model;

import java.util.List;

public class VatWithhPRNRequest {
    private PRNRequestHeader transactionHeader;
    private List<VatWithhDetails> transactionDetails;
    
    private VatWithhPRNRequest(Builder builder){
        this.transactionDetails=builder.transactionDetails;
        this.transactionHeader=builder.transactionHeader;
    }
    private static class Builder{
        private PRNRequestHeader transactionHeader;
        private List<VatWithhDetails> transactionDetails;

        public Builder TransactionDetails(List<VatWithhDetails> transactionDetails) {
            this.transactionDetails = transactionDetails;
            return this;
        }
        public Builder TransactionHeader(PRNRequestHeader transactionHeader) {
            this.transactionHeader = transactionHeader;
            return this;
        }

        public VatWithhPRNRequest build(){
            return new VatWithhPRNRequest(this);
        }
    }

    public Builder builder(){
        return new Builder();
    }

    public List<VatWithhDetails> getTransactionDetails() {
        return transactionDetails;
    }
    public PRNRequestHeader getTransactionHeader() {
        return transactionHeader;
    }
}
