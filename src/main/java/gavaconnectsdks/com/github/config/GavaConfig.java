package gavaconnectsdks.com.github.config;

public class GavaConfig {
    private final String consumerKey;
    private final String consumerSecret;
    private Environment environment=Environment.SANDBOX;

    public GavaConfig(String consumerKey,String consumerSecret,Environment environment){
        this.consumerKey=consumerKey;
        this.consumerSecret=consumerSecret;
        this.environment=environment;
    }
    public GavaConfig(String consumerKey,String consumerSecret){
        this.consumerKey=consumerKey;
        this.consumerSecret=consumerSecret;
    }

    public String getConsumerKey() {
        return this.consumerKey;
    }

    public String getConsumerSecret() {
        return this.consumerSecret;
    }
    
    public Environment getEnvironment() {
        return this.environment;
    }

}
