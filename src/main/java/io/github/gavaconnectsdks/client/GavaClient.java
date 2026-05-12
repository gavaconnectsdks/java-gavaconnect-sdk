package io.github.gavaconnectsdks.client;
import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.client.ClientFacades.ApplicationFacade;
import io.github.gavaconnectsdks.client.ClientFacades.CheckerFacade;
import io.github.gavaconnectsdks.client.ClientFacades.RegistrationFacade;
import io.github.gavaconnectsdks.client.ClientFacades.StationFacade;
import io.github.gavaconnectsdks.client.ClientFacades.WithholdingPRNGeneratorFacade;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.exceptions.BadRequestException;
import io.github.gavaconnectsdks.http.GavaHttpClient;

public class GavaClient {
    private final Auth auth;
    private final GavaConfig gavaConfig;
    private GavaHttpClient httpClient;
    public GavaClient(GavaConfig gavaConfig){
        if(gavaConfig==null){
            throw new BadRequestException("Configuration cannot be null");
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
            throw new BadRequestException(fieldName+"in config is required");
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
