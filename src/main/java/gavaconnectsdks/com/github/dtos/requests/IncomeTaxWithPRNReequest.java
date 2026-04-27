package gavaconnectsdks.com.github.dtos.requests;

import java.util.List;

import gavaconnectsdks.com.github.dtos.IncomeTaxWithhDetails;
import gavaconnectsdks.com.github.dtos.PRNRequestHeader;

public class IncomeTaxWithPRNReequest {
    private final PRNRequestHeader transactionHeader;
    private final List<IncomeTaxWithhDetails> transactionDetails;


    public IncomeTaxWithPRNReequest(Builder builder){
        this.transactionDetails=builder.transactionDetails;
        this.transactionHeader=builder.transactionHeader;
    }

    private  static class Builder{
        private PRNRequestHeader transactionHeader;
        private List<IncomeTaxWithhDetails> transactionDetails;

        public Builder TransactionDetails(List<IncomeTaxWithhDetails> transactionDetails) {
            this.transactionDetails = transactionDetails;
            return this;
        }

        public Builder TransactionHeader(PRNRequestHeader transactionHeader) {
            this.transactionHeader = transactionHeader;
            return this;
        }

        public IncomeTaxWithPRNReequest build(){
            return new IncomeTaxWithPRNReequest(this);
        }
        

    }
 

    public PRNRequestHeader getTransactioHeader() {
        return this.transactionHeader;
    }

    public List<IncomeTaxWithhDetails> getTransactionDetails() {
        return this.transactionDetails;
    }

    public static Builder builder(){
        return new Builder();
    }

}
