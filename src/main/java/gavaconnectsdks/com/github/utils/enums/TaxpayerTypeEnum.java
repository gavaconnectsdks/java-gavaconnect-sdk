package gavaconnectsdks.com.github.utils.enums;

public enum TaxpayerTypeEnum {
    KENYAN_RESIDENT("KE"),
    NON_KENYAN_RESIDENT("NKE"),
    NON_KENYAN_NON_RESIDENT("NKENR"),
    COMPANY("COM");

    private final String taxpayerType;

    TaxpayerTypeEnum(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getTaxpayerType(){
        return taxpayerType;
    }

     public static TaxpayerTypeEnum fromCode(String taxpayerType){

        if(taxpayerType==null){
            throw new IllegalArgumentException("Invalid TaxpayerType: "+taxpayerType);
        }
        for (TaxpayerTypeEnum c:values()){
            if(c.taxpayerType.equals(taxpayerType)){
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid TaxpayerTpe: "+taxpayerType);

    }

    public static boolean isValid(String taxpayerType){

        if(taxpayerType==null){
            return false;
        }
        for (TaxpayerTypeEnum c:values()){
            if(c.taxpayerType.equals(taxpayerType)){
                return true;
            }
        }
        return false;
    }
    
}
