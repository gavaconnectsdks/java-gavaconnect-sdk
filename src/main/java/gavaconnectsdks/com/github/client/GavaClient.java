package gavaconnectsdks.com.github.client;
import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.client.ClientFacades.ApplicationFacade;
import gavaconnectsdks.com.github.client.ClientFacades.CheckerFacade;
import gavaconnectsdks.com.github.client.ClientFacades.RegistrationFacade;
import gavaconnectsdks.com.github.client.ClientFacades.StationFacade;
import gavaconnectsdks.com.github.client.ClientFacades.WithholdingPRNGeneratorFacade;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.CustDecStatusCheckerRequest;
import gavaconnectsdks.com.github.dtos.requests.ExciseLicenceCheckerByCertNoRequest;
import gavaconnectsdks.com.github.dtos.requests.ExciseLicenseCheckerByPinRequest;
import gavaconnectsdks.com.github.dtos.requests.FetchTaxpayerObligationRequest;
import gavaconnectsdks.com.github.dtos.requests.ITExceptionCheckerRequest;
import gavaconnectsdks.com.github.dtos.requests.ImportCertCheckerByPinRequest;
import gavaconnectsdks.com.github.dtos.requests.ImportCertificateCheckerRequest;
import gavaconnectsdks.com.github.dtos.requests.IncomeTaxWithPRNReequest;
import gavaconnectsdks.com.github.dtos.requests.InvoiceCheckerRequest;
import gavaconnectsdks.com.github.dtos.requests.KnowKraOfficeRequest;
import gavaconnectsdks.com.github.dtos.requests.NilReturnRequest;
import gavaconnectsdks.com.github.dtos.requests.PinCheckerByIdRequest;
import gavaconnectsdks.com.github.dtos.requests.PinCheckerByPinRequest;
import gavaconnectsdks.com.github.dtos.requests.PinRegistrationRequest;
import gavaconnectsdks.com.github.dtos.requests.RentalIncomeWithhPRNRequest;
import gavaconnectsdks.com.github.dtos.requests.TccApplicationRequest;
import gavaconnectsdks.com.github.dtos.requests.TccCheckerrequest;
import gavaconnectsdks.com.github.dtos.requests.ToTReturnsRequest;
import gavaconnectsdks.com.github.dtos.requests.VatExcemptionCheckerRequest;
import gavaconnectsdks.com.github.dtos.requests.VatWithhPRNRequest;
import gavaconnectsdks.com.github.dtos.responses.CustDecStatusCheckerResponse;
import gavaconnectsdks.com.github.dtos.responses.ExciseLicenseCheckerByPinResponse;
import gavaconnectsdks.com.github.dtos.responses.ExciseLinenceCheckerByCertNoresponse;
import gavaconnectsdks.com.github.dtos.responses.FetchTaxpayerObligationresponse;
import gavaconnectsdks.com.github.dtos.responses.ITExemptionCheckerResponse;
import gavaconnectsdks.com.github.dtos.responses.ImportCertCheckerByPinResponse;
import gavaconnectsdks.com.github.dtos.responses.ImportCertificateCheckerResponse;
import gavaconnectsdks.com.github.dtos.responses.InvoiceCheckerResponse;
import gavaconnectsdks.com.github.dtos.responses.KnowKraOfficeResponse;
import gavaconnectsdks.com.github.dtos.responses.NilReturnResponse;
import gavaconnectsdks.com.github.dtos.responses.PinCheckerByIdResponse;
import gavaconnectsdks.com.github.dtos.responses.PinCheckerByPinResponse;
import gavaconnectsdks.com.github.dtos.responses.PinRegistrationResponse;
import gavaconnectsdks.com.github.dtos.responses.TccApplicationResponse;
import gavaconnectsdks.com.github.dtos.responses.TccCheckerResponse;
import gavaconnectsdks.com.github.dtos.responses.ToTReturnsResponse;
import gavaconnectsdks.com.github.dtos.responses.VatExcemptionCheckerResponse;
import gavaconnectsdks.com.github.dtos.responses.WithholdingPRNResponse;
import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.http.GavaHttpClient;

public class GavaClient {
    private final Auth auth;
    private final GavaConfig gavaConfig;
    private GavaHttpClient httpClient;
    public GavaClient(GavaConfig gavaConfig){
        this.gavaConfig=gavaConfig;
        this.httpClient=GavaHttpClient.builder()
                                      .baseUrl(gavaConfig.getEnvironment().getBaseUrl())
                                      .build();
        this.auth = new Auth(gavaConfig.getConsumerKey(),gavaConfig.getConsumerSecret(),gavaConfig.getEnvironment(),this.httpClient);
    }

    public String getToken(){
        return auth.getAccessToken();
    }

    public ApplicationFacade applications(){
        return new ApplicationFacade();
    }
    public CheckerFacade checkers(){
        return new CheckerFacade();
    }
    public RegistrationFacade registrations(){
        return new RegistrationFacade();
    }

    public StationFacade stations(){
        return new StationFacade();
    }
    public WithholdingPRNGeneratorFacade prnGenerator(){
        return  new WithholdingPRNGeneratorFacade();
    }

}
