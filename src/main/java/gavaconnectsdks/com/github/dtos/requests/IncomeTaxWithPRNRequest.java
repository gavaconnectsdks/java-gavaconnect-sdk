package gavaconnectsdks.com.github.dtos.requests;

import java.util.List;

import gavaconnectsdks.com.github.dtos.IncomeTaxWithhDetails;
import gavaconnectsdks.com.github.dtos.PRNRequestHeader;
import gavaconnectsdks.com.github.exceptions.ValidationException;

public class IncomeTaxWithPRNRequest {
    private final PRNRequestHeader transactionHeader;
    private final List<IncomeTaxWithhDetails> transactionDetails;


    public IncomeTaxWithPRNRequest(Builder builder){
        this.transactionDetails=builder.transactionDetails;
        this.transactionHeader=builder.transactionHeader;
    }

    private  static class Builder{
        private PRNRequestHeader transactionHeader;
        private List<IncomeTaxWithhDetails> transactionDetails;

        public Builder transactionDetails(List<IncomeTaxWithhDetails> transactionDetails) {
            this.transactionDetails = transactionDetails;
            return this;
        }

        public Builder transactionHeader(PRNRequestHeader transactionHeader) {
            this.transactionHeader = transactionHeader;
            return this;
        }

        public IncomeTaxWithPRNRequest build(){
            if(this.transactionHeader==null){
                throw new ValidationException("transactionHeader is required");
            }
            if(this.transactionDetails==null){
                throw new ValidationException("transactionDetails is required");
            }
            return new IncomeTaxWithPRNRequest(this);
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
