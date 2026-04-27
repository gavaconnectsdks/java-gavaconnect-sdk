package gavaconnectsdks.com.github.client;
import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.client.ClientFacades.ApplicationFacade;
import gavaconnectsdks.com.github.client.ClientFacades.CheckerFacade;
import gavaconnectsdks.com.github.client.ClientFacades.RegistrationFacade;
import gavaconnectsdks.com.github.client.ClientFacades.StationFacade;
import gavaconnectsdks.com.github.client.ClientFacades.WithholdingPRNGeneratorFacade;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.http.GavaHttpClient;

public class GavaClient {
    private final Auth auth;
    private final GavaConfig gavaConfig;
    private GavaHttpClient httpClient;
    public GavaClient(GavaConfig gavaConfig){
        if(gavaConfig==null){
            throw new ValidationException("Configuration cannot be null");
        }

        this.validateConfig(gavaConfig.getConsumerKey(), "consumerKey");

        this.validateConfig(gavaConfig.getConsumerSecret(), "consumerSecret");

        this.gavaConfig=gavaConfig;
        this.httpClient=GavaHttpClient.builder()
                                      .baseUrl(gavaConfig.getEnvironment().getBaseUrl())
                                      .build();
        this.auth = new Auth(gavaConfig.getConsumerKey(),gavaConfig.getConsumerSecret(),gavaConfig.getEnvironment(),this.httpClient);
    }

    private void validateConfig(String value,String fieldName){
        if(value==null||value.trim().isEmpty()){
            throw new ValidationException(fieldName+"in config is required");
        }
    }

    public ApplicationFacade applications(){
        return new ApplicationFacade(this.gavaConfig,this.auth);
    }
    public CheckerFacade checkers(){
        return new CheckerFacade(this.gavaConfig,this.auth);
    }
    public RegistrationFacade registrations(){
        return new RegistrationFacade(this.gavaConfig,this.auth);
    }

    public StationFacade stations(){
        return new StationFacade(this.gavaConfig,this.auth);
    }
    public WithholdingPRNGeneratorFacade withholdingPRNGenerator(){
        return  new WithholdingPRNGeneratorFacade(this.gavaConfig,this.auth);
    }

}
