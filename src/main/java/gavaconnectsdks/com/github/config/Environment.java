package gavaconnectsdks.com.github.config;

public enum Environment {
    SANDBOX("https://sbx.kra.go.ke"),
    PRODUCTION("https://api.kra.go.ke");

    private final String baseUrl;

    Environment(String base){
        baseUrl=base;
    }
    public String getBaseUrl(){
        return  baseUrl;
    }
    
}
