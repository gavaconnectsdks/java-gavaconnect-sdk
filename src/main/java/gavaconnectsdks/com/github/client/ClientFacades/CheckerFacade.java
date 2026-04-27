package gavaconnectsdks.com.github.client.ClientFacades;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.CustDecStatusCheckerRequest;
import gavaconnectsdks.com.github.dtos.requests.ExciseLicenceCheckerByCertNoRequest;
import gavaconnectsdks.com.github.dtos.requests.ExciseLicenseCheckerByPinRequest;
import gavaconnectsdks.com.github.dtos.requests.FetchTaxpayerObligationRequest;
import gavaconnectsdks.com.github.dtos.requests.ITExceptionCheckerRequest;
import gavaconnectsdks.com.github.dtos.requests.ImportCertCheckerByPinRequest;
import gavaconnectsdks.com.github.dtos.requests.ImportCertificateCheckerRequest;
import gavaconnectsdks.com.github.dtos.requests.InvoiceCheckerRequest;
import gavaconnectsdks.com.github.dtos.requests.PinCheckerByIdRequest;
import gavaconnectsdks.com.github.dtos.requests.PinCheckerByPinRequest;
import gavaconnectsdks.com.github.dtos.requests.TccCheckerRequest;
import gavaconnectsdks.com.github.dtos.requests.VatExcemptionCheckerRequest;
import gavaconnectsdks.com.github.dtos.responses.CustDecStatusCheckerResponse;
import gavaconnectsdks.com.github.dtos.responses.ExciseLicenseCheckerByPinResponse;
import gavaconnectsdks.com.github.dtos.responses.ExciseLicenceCheckerByCertNoResponse;
import gavaconnectsdks.com.github.dtos.responses.FetchTaxpayerObligationresponse;
import gavaconnectsdks.com.github.dtos.responses.ITExemptionCheckerResponse;
import gavaconnectsdks.com.github.dtos.responses.ImportCertCheckerByPinResponse;
import gavaconnectsdks.com.github.dtos.responses.ImportCertificateCheckerResponse;
import gavaconnectsdks.com.github.dtos.responses.InvoiceCheckerResponse;
import gavaconnectsdks.com.github.dtos.responses.PinCheckerByIdResponse;
import gavaconnectsdks.com.github.dtos.responses.PinCheckerByPinResponse;
import gavaconnectsdks.com.github.dtos.responses.TccCheckerResponse;
import gavaconnectsdks.com.github.dtos.responses.VatExcemptionCheckerResponse;
import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.service.CustDecStatusCheckerService;
import gavaconnectsdks.com.github.service.ExciseLicenceCheckerByCertificateService;
import gavaconnectsdks.com.github.service.ExciseLicenceCheckerByPin;
import gavaconnectsdks.com.github.service.ITExemptionCheckerService;
import gavaconnectsdks.com.github.service.ImportCertificateCheckerByCertService;
import gavaconnectsdks.com.github.service.ImportCertificateCheckerByPinService;
import gavaconnectsdks.com.github.service.InvoiceCheckerService;
import gavaconnectsdks.com.github.service.PinChechkerByPinService;
import gavaconnectsdks.com.github.service.PinCheckerByIdService;
import gavaconnectsdks.com.github.service.TaxPayerObligationService;
import gavaconnectsdks.com.github.service.TccCheckerService;
import gavaconnectsdks.com.github.service.VatExemptionCheckerService;

public class CheckerFacade {

    private final GavaConfig config;
    private final Auth auth;

    public CheckerFacade(GavaConfig config,Auth auth){
        this.config=config;
        this.auth=auth;
    }


    public TccCheckerResponse checkTaxCompliance(TccCheckerRequest tccCheckerRequest) throws IOException,InterruptedException,IllegalAccessException{
        try {
            if(tccCheckerRequest==null) throw new ValidationException("Request body is required.");
            TccCheckerService tccCheckerService=new TccCheckerService(this.config, this.auth);

            return tccCheckerService.request(tccCheckerRequest);
            
        } catch (IOException  | InterruptedException | IllegalAccessException e) {
            throw e;
        }
    }

    public CustDecStatusCheckerResponse checkCustomsDeclarationStatus(CustDecStatusCheckerRequest custDecStatusCheckerRequest) throws IOException,InterruptedException,IllegalAccessException{

        try {
            if(custDecStatusCheckerRequest==null) throw new ValidationException("Request body is required.");
            CustDecStatusCheckerService custDecStatusCheckerService=new CustDecStatusCheckerService(this.config, this.auth);

            return custDecStatusCheckerService.request(custDecStatusCheckerRequest);

        } catch (IOException  | InterruptedException | IllegalAccessException e) {
            throw e;
        }   
    }

    public VatExcemptionCheckerResponse checkVatExemption(VatExcemptionCheckerRequest vatExcemptionCheckerRequest) throws IOException,InterruptedException,IllegalAccessException{
        try {
            if(vatExcemptionCheckerRequest==null) throw new ValidationException("Request body is required.");
            VatExemptionCheckerService vatExemptionCheckerService=new VatExemptionCheckerService(this.config, this.auth);

            return vatExemptionCheckerService.requst(vatExcemptionCheckerRequest);
            
        } catch (IOException  | InterruptedException | IllegalAccessException e) {
            throw e;
        }
   
    }

    public ExciseLicenseCheckerByPinResponse checkExciseLicenseByPIN(ExciseLicenseCheckerByPinRequest exciseLicenseCheckerByPinRequest )throws IOException,InterruptedException,IllegalAccessException{
        try {
            if(exciseLicenseCheckerByPinRequest==null) throw new ValidationException("Request body is required.");

            ExciseLicenceCheckerByPin exciseLicenceCheckerByPin=new ExciseLicenceCheckerByPin(this.config, this.auth);
            return exciseLicenceCheckerByPin.request(exciseLicenseCheckerByPinRequest);
            
        } catch (IOException  | InterruptedException | IllegalAccessException e) {
            throw e;
        }

    }
       public ExciseLicenceCheckerByCertNoResponse checkExciseLicenseByCertificateNumber(ExciseLicenceCheckerByCertNoRequest exciseLicenceCheckerByCertNoRequest) throws IOException ,InterruptedException,IllegalAccessException{
        try {
            if(exciseLicenceCheckerByCertNoRequest==null) throw new ValidationException("Request body is required.");
            ExciseLicenceCheckerByCertificateService exciseLicenceCheckerByCertificateService=new ExciseLicenceCheckerByCertificateService(this.config, this.auth);

            return exciseLicenceCheckerByCertificateService.request(exciseLicenceCheckerByCertNoRequest);
        } catch (IOException  | InterruptedException | IllegalAccessException e) {
            throw e;
        }
    
    }

    public InvoiceCheckerResponse checkInvoice(InvoiceCheckerRequest invoiceCheckerRequest)throws IOException ,InterruptedException,IllegalAccessException{

        try {

        if(invoiceCheckerRequest==null) throw new ValidationException("Request body is required.");
        InvoiceCheckerService invoiceCheckerService=new InvoiceCheckerService(this.config, this.auth);

        return invoiceCheckerService.request(invoiceCheckerRequest);
            
        } catch (IOException  | InterruptedException | IllegalAccessException  e) {
            throw e;
        }


    }
     public ITExemptionCheckerResponse checkIncomeTaxExemption(ITExceptionCheckerRequest itExceptionCheckerRequest )throws IOException ,InterruptedException,IllegalAccessException{
        try {
            if(itExceptionCheckerRequest==null) throw new ValidationException("Request body is required.");
            ITExemptionCheckerService itExemptionCheckerService=new ITExemptionCheckerService(this.config, this.auth);

            return itExemptionCheckerService.request(itExceptionCheckerRequest);
            
        } catch (IOException  | InterruptedException | IllegalAccessException  e) {
            throw e;
        }
     
    }

    public ImportCertificateCheckerResponse checkImportCertificateByCertificateNumber(ImportCertificateCheckerRequest importCertificateCheckerRequest )throws IOException ,InterruptedException,IllegalAccessException{

        try {
            if(importCertificateCheckerRequest==null) throw new ValidationException("Request body is required.");
            ImportCertificateCheckerByCertService importCertificateCheckerByCertService=new ImportCertificateCheckerByCertService(this.config, this.auth);

            return importCertificateCheckerByCertService.request(importCertificateCheckerRequest);
            
        } catch (IOException  | InterruptedException | IllegalAccessException e) {
            throw e;
        }
     
    }

    public ImportCertCheckerByPinResponse checkImportCertificateByPIN(ImportCertCheckerByPinRequest importCertCheckerByPinRequest )throws IOException ,InterruptedException,IllegalAccessException{
        try {
            if(importCertCheckerByPinRequest==null) throw new ValidationException("Request body is required.");
            ImportCertificateCheckerByPinService importCertificateCheckerByPinService=new ImportCertificateCheckerByPinService(this.config, this.auth);

            return importCertificateCheckerByPinService.request(importCertCheckerByPinRequest);
            
        } catch (IOException  | InterruptedException | IllegalAccessException e) {
            throw e;
        }

    }

    public FetchTaxpayerObligationresponse checkTaxpayerObligations(FetchTaxpayerObligationRequest fetchTaxpayerObligationRequest )throws IOException ,InterruptedException,IllegalAccessException{
        try {
                if(fetchTaxpayerObligationRequest==null) throw new ValidationException("Request body is required.");
                TaxPayerObligationService taxPayerObligationService=new TaxPayerObligationService(this.config, this.auth);
                
                return taxPayerObligationService.request(fetchTaxpayerObligationRequest);
            
        } catch (IOException  | InterruptedException | IllegalAccessException e) {
            throw e;
        }

    }
    
    public PinCheckerByPinResponse checkPINByPIN(PinCheckerByPinRequest pinCheckerByPinRequest )throws IOException ,InterruptedException,IllegalAccessException{
        try {
            if(pinCheckerByPinRequest==null) throw new ValidationException("Request body is required.");
            PinChechkerByPinService pinChechkerByPinService=new PinChechkerByPinService(this.config, this.auth);

            return pinChechkerByPinService.request(pinCheckerByPinRequest);
        } catch (IOException  | InterruptedException | IllegalAccessException e) {
            throw e;
        }

    }

    public PinCheckerByIdResponse checkPINByID(PinCheckerByIdRequest pinCheckerByIdRequest)throws IOException ,InterruptedException,IllegalAccessException{
        try {
                if(pinCheckerByIdRequest==null) throw new ValidationException("Request body is required.");
                PinCheckerByIdService pinCheckerByIdService=new PinCheckerByIdService(this.config, this.auth);
                return pinCheckerByIdService.request(pinCheckerByIdRequest);
        } catch (IOException  | InterruptedException | IllegalAccessException e ) {
            throw e;
        }

    }
}
