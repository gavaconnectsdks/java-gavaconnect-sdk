package gavaconnectsdks.com.github.model;

public class CustDecStatusCheckerRequest {
    private String DeclarationNo;

    private CustDecStatusCheckerRequest(Builder builder){
        this.DeclarationNo=builder.DeclarationNo;
    }
    private static class Builder{
        private String DeclarationNo;
        
        public Builder DeclarationNo(String DeclarationNo) {
            this.DeclarationNo = DeclarationNo;
            return this;
        }
        public CustDecStatusCheckerRequest build (){
            return new CustDecStatusCheckerRequest(this);
        }
        
    }

    public String getDeclarationNo() {
        return this.DeclarationNo;
    }
    public static Builder builder(){
        return new Builder();
    }
    
}
