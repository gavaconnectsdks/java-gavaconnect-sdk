package gavaconnectsdks.com.github.model;

import gavaconnectsdks.com.github.utils.annotations.Pin;

public class TccCheckerrequest {
    @Pin
    private String kraPIN;
    private  String tccNumber;

    private TccCheckerrequest(Builder builder){
        this.kraPIN=builder.kraPIN;
        this.tccNumber=builder.tccNumber;
    }

    private static class Builder{
        private  String kraPIN;
        private String tccNumber;


        public Builder KraPIN(String kraPIN) {
            this.kraPIN = kraPIN;
            return this;
        }

        public Builder TccNumber(String tccNumber) {
            this.tccNumber = tccNumber;
            return this;
        }

        public TccCheckerrequest build(){
            return new TccCheckerrequest(this);
        }
        
    }

    public String getKraPIN() {
        return this.kraPIN;
    }

    public String getTccNumber() {
        return this.tccNumber;
    }

    public static Builder builder(){
        return new Builder();
    }
    
}
