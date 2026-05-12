package io.github.gavaconnectsdks.dtos.requests;

import java.util.List;

import io.github.gavaconnectsdks.dtos.IncomeTaxWithhDetails;
import io.github.gavaconnectsdks.dtos.PRNRequestHeader;
import io.github.gavaconnectsdks.exceptions.BadRequestException;

public class IncomeTaxWithPRNRequest {
    private final PRNRequestHeader transactionHeader;
    private final List<IncomeTaxWithhDetails> transactionDetails;


    public IncomeTaxWithPRNRequest(Builder builder){
        this.transactionDetails=builder.transactionDetails;
        this.transactionHeader=builder.transactionHeader;
    }

    public  static class Builder{
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
                throw new BadRequestException("transactionHeader is required");
            }
            if(this.transactionDetails==null){
                throw new BadRequestException("transactionDetails is required");
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
