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
    public String fileNilReturn(NilReturnRequest nilReturnRequest){

        return "";
    }

    public String fileTurnOverTaxReturn(ToTReturnsRequest toTReturnsRequest){
        return "";
    }

    public String checkPINByPIN(PinCheckerByPinRequest pinCheckerByPinRequest ){
        return "";
    }

    public String checkPINByID(PinCheckerByIdRequest pinCheckerByIdRequest){
        return "";
    }

    public String knowKRATaxServiceOffice(KnowKraOfficeRequest knowKraOfficeRequest){
        return "";
    }

    public String checkIncomeTaxExemption( ){
        return "";
    }

    public String checkImportCertificateByCertificateNumber(ImportCertificateCheckerRequest importCertificateCheckerRequest ){
        return "";
    }

    public String checkImportCertificateByPIN(ImportCertCheckerByPinRequest importCertCheckerByPinRequest ){
        return "";
    }

    public String fetchTaxpayerObligations(FetchTaxpayerObligationRequest fetchTaxpayerObligationRequest ){
        return "";
    }

    public String registerKRAPINIndividual(PinRegistrationRequest pinRegistrationRequest){
        return "";
    }

    public String applyTaxComplianceCertificate(TccApplicationRequest tccApplicationRequest){
        return "";
    }

    public String checkTaxCompliance(TccCheckerrequest tccCheckerrequest){
        return "";
    }

    public String checkCustomsDeclarationStatus(CustDecStatusCheckerRequest custDecStatusCheckerRequest){
        return "";
    }

    public String checkVatExemption(VatExcemptionCheckerRequest vatExcemptionCheckerRequest){
        return "";
    }

    public String checkExciseLicenseByPIN(ExciseLicenseCheckerByPinRequest exciseLicenseCheckerByPinRequest ){
        return "";
    }

    public String checkExciseLicenseByCertificateNumber(ExciseLicenceCheckerByCertNoRequest exciseLicenceCheckerByCertNoRequest){
        return "";
    }

    public String checkInvoice(InvoiceCheckerRequest invoiceCheckerRequest){
        return "";
    }

    public String generateIncomeTaxWithholdingPRN(IncomeTaxWithPRNReequest incomeTaxWithPRNReequest ){
        return "";
    }

    public String generateRentalWithholdingPRN(RentalIncomeWithhPRNRequest rentalIncomeWithhPRNRequest){
        return "";
    }

    public String generateVATWithholdingPRN(VatWithhPRNRequest vatWithhPRNRequest){
        return "";
    }



}
