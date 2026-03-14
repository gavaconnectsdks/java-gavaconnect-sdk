package gavaconnectsdks.com.github.utils.enums;

public enum ObligationCode {
    INCOME_TAX_INDIVIDUAL_RESIDENT(1),
    INCOME_TAX_INDIVIDUAL_NON_RESIDENT(2),
    INCOME_TAX_INDIVIDUAL_PARTNERSHIP(3),
    INCOME_TAX_COMPANY(4),
    VAT(5),
    INCOME_TAX_PAYE(6),
    EXCISE(7),
    INCOME_TAX_RENT_INCOME_MRI(8);

    private final int code;

    ObligationCode(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

     public static ObligationCode fromCode(Integer obligationCode){

        if(obligationCode==null){
            throw new IllegalArgumentException("Invalid obligation code: "+obligationCode);
        }
        for (ObligationCode c:values()){
            if(c.code==obligationCode){
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid obli code: "+obligationCode);

    }

    public static boolean isValid(Integer obligationCode){

        if(obligationCode==null){
            return false;
        }
        for (ObligationCode c:values()){
            if(c.code==obligationCode){
                return true;
            }
        }
        return false;
    }
    
}
