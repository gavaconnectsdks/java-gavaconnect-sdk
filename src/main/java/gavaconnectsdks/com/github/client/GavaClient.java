package gavaconnectsdks.com.github.client;


import java.time.Instant;
import java.util.Base64;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gavaconnectsdks.com.github.config.Environment;
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
        this.auth = new Auth(gavaConfig.getConsumerKey(),gavaConfig.getConsumerSecret(),gavaConfig.getEnvironment());
        this.httpClient=GavaHttpClient.builder()
                                      .baseUrl(gavaConfig.getEnvironment().getBaseUrl())
                                      .build();

    }

    private static class OAuthObject{
        @JsonProperty("access_token")
        private String accessToken;

        @JsonProperty("expires_in")
        private Long expiresIn;

        public OAuthObject(){}
        public OAuthObject(String accessToken,Long expiresIn){
            this.accessToken=accessToken;
            this.expiresIn=expiresIn;
        }        

        public String getAccessToken() {
            return this.accessToken;
        }

        public Long getExpiresIn() {
            return this.expiresIn;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public void setExpiresIn(Long expiresIn) {
            this.expiresIn = expiresIn;
        }

    }

    public class Auth{
        private String accessToken;
        private Long expiresAt;
        private String consumerKey;
        private String consumerSecret;
        private Environment environment;
        private ObjectMapper objectMapper = new ObjectMapper();

        public Auth(String consumerKey,String consumerSecret,Environment environment){
            this.consumerKey=consumerKey;
            this.consumerSecret=consumerSecret;
            this.environment=environment;
        }

        public String getAuthorizationBearerHeader() throws JsonProcessingException {
            return objectMapper.writeValueAsString(Map.ofEntries(Map.entry("Authorization", "Bearer "+this.getAccessToken())));   
        }

        public String getAccessToken(){

            try{

            if(this.accessToken==null||this.expiresAt<Instant.now().getEpochSecond()){
                String path="/v1/token/generate?grant_type=client_credentials";
                StringBuilder ConsumerKeyConsumerSecret=new StringBuilder();
                ConsumerKeyConsumerSecret.append(this.consumerKey)
                                         .append(":")
                                         .append(this.consumerSecret);
                
                String base64ConsumerKeyConsumerSecret=Base64.getEncoder()
                                                             .encodeToString(ConsumerKeyConsumerSecret.toString().getBytes());
                Map<String,String> header=Map.ofEntries(Map.entry("Authorization","Basic "+base64ConsumerKeyConsumerSecret));
                OAuthObject response=httpClient.get(path, OAuthObject.class, header);
                this.accessToken=response.getAccessToken();
                this.expiresAt=Instant.now().getEpochSecond()+response.getExpiresIn();
            }

            return this.accessToken;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    }

    public String getToken(){
        return auth.getAccessToken();
    }
    public NilReturnResponse fileNilReturn(NilReturnRequest nilReturnRequest){
        if(nilReturnRequest==null) throw new ValidationException("Request body cannot be null");

           return null;
    }

    public ToTReturnsResponse fileTurnOverTaxReturn(ToTReturnsRequest toTReturnsRequest){
        if(toTReturnsRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public PinCheckerByPinResponse checkPINByPIN(PinCheckerByPinRequest pinCheckerByPinRequest ){
        if(pinCheckerByPinRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public PinCheckerByIdResponse checkPINByID(PinCheckerByIdRequest pinCheckerByIdRequest){
        if(pinCheckerByIdRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public KnowKraOfficeResponse knowKRATaxServiceOffice(KnowKraOfficeRequest knowKraOfficeRequest){
        if(knowKraOfficeRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public ITExemptionCheckerResponse checkIncomeTaxExemption(ITExceptionCheckerRequest itExceptionCheckerRequest ){
        if(itExceptionCheckerRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public ImportCertificateCheckerResponse checkImportCertificateByCertificateNumber(ImportCertificateCheckerRequest importCertificateCheckerRequest ){
        if(importCertificateCheckerRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public ImportCertCheckerByPinResponse checkImportCertificateByPIN(ImportCertCheckerByPinRequest importCertCheckerByPinRequest ){
        if(importCertCheckerByPinRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public FetchTaxpayerObligationresponse fetchTaxpayerObligations(FetchTaxpayerObligationRequest fetchTaxpayerObligationRequest ){
        if(fetchTaxpayerObligationRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public PinRegistrationResponse registerKRAPINIndividual(PinRegistrationRequest pinRegistrationRequest){
        if(pinRegistrationRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public TccApplicationResponse applyTaxComplianceCertificate(TccApplicationRequest tccApplicationRequest){
        if(tccApplicationRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public TccCheckerResponse checkTaxCompliance(TccCheckerrequest tccCheckerrequest){
        if(tccCheckerrequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public CustDecStatusCheckerResponse checkCustomsDeclarationStatus(CustDecStatusCheckerRequest custDecStatusCheckerRequest){
        if(custDecStatusCheckerRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public VatExcemptionCheckerResponse checkVatExemption(VatExcemptionCheckerRequest vatExcemptionCheckerRequest){
        if(vatExcemptionCheckerRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public ExciseLicenseCheckerByPinResponse checkExciseLicenseByPIN(ExciseLicenseCheckerByPinRequest exciseLicenseCheckerByPinRequest ){
        if(exciseLicenseCheckerByPinRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public ExciseLinenceCheckerByCertNoresponse checkExciseLicenseByCertificateNumber(ExciseLicenceCheckerByCertNoRequest exciseLicenceCheckerByCertNoRequest){
        if(exciseLicenceCheckerByCertNoRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public InvoiceCheckerResponse checkInvoice(InvoiceCheckerRequest invoiceCheckerRequest){
        if(invoiceCheckerRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public WithholdingPRNResponse generateIncomeTaxWithholdingPRN(IncomeTaxWithPRNReequest incomeTaxWithPRNReequest ){
        if(incomeTaxWithPRNReequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public WithholdingPRNResponse generateRentalWithholdingPRN(RentalIncomeWithhPRNRequest rentalIncomeWithhPRNRequest){
        if(rentalIncomeWithhPRNRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }

    public WithholdingPRNResponse generateVATWithholdingPRN(VatWithhPRNRequest vatWithhPRNRequest){
        if(vatWithhPRNRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }



}
