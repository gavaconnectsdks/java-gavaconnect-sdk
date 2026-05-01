package io.github.gavaconnectsdks.client.ClientFacades;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.CustDecStatusCheckerRequest;
import io.github.gavaconnectsdks.dtos.requests.ExciseLicenceCheckerByCertNoRequest;
import io.github.gavaconnectsdks.dtos.requests.ExciseLicenseCheckerByPinRequest;
import io.github.gavaconnectsdks.dtos.requests.FetchTaxpayerObligationRequest;
import io.github.gavaconnectsdks.dtos.requests.ITExceptionCheckerRequest;
import io.github.gavaconnectsdks.dtos.requests.ImportCertCheckerByPinRequest;
import io.github.gavaconnectsdks.dtos.requests.ImportCertificateCheckerRequest;
import io.github.gavaconnectsdks.dtos.requests.InvoiceCheckerRequest;
import io.github.gavaconnectsdks.dtos.requests.PinCheckerByIdRequest;
import io.github.gavaconnectsdks.dtos.requests.PinCheckerByPinRequest;
import io.github.gavaconnectsdks.dtos.requests.TccCheckerRequest;
import io.github.gavaconnectsdks.dtos.requests.VatExcemptionCheckerRequest;
import io.github.gavaconnectsdks.dtos.responses.CustDecStatusCheckerResponse;
import io.github.gavaconnectsdks.dtos.responses.ExciseLicenceCheckerByCertNoResponse;
import io.github.gavaconnectsdks.dtos.responses.ExciseLicenseCheckerByPinResponse;
import io.github.gavaconnectsdks.dtos.responses.FetchTaxpayerObligationresponse;
import io.github.gavaconnectsdks.dtos.responses.ITExemptionCheckerResponse;
import io.github.gavaconnectsdks.dtos.responses.ImportCertCheckerByPinResponse;
import io.github.gavaconnectsdks.dtos.responses.ImportCertificateCheckerResponse;
import io.github.gavaconnectsdks.dtos.responses.InvoiceCheckerResponse;
import io.github.gavaconnectsdks.dtos.responses.PinCheckerByIdResponse;
import io.github.gavaconnectsdks.dtos.responses.PinCheckerByPinResponse;
import io.github.gavaconnectsdks.dtos.responses.TccCheckerResponse;
import io.github.gavaconnectsdks.dtos.responses.VatExcemptionCheckerResponse;
import io.github.gavaconnectsdks.exceptions.ValidationException;
import io.github.gavaconnectsdks.service.CustDecStatusCheckerService;
import io.github.gavaconnectsdks.service.ExciseLicenceCheckerByCertificateService;
import io.github.gavaconnectsdks.service.ExciseLicenceCheckerByPin;
import io.github.gavaconnectsdks.service.ITExemptionCheckerService;
import io.github.gavaconnectsdks.service.ImportCertificateCheckerByCertService;
import io.github.gavaconnectsdks.service.ImportCertificateCheckerByPinService;
import io.github.gavaconnectsdks.service.InvoiceCheckerService;
import io.github.gavaconnectsdks.service.PinChechkerByPinService;
import io.github.gavaconnectsdks.service.PinCheckerByIdService;
import io.github.gavaconnectsdks.service.TaxPayerObligationService;
import io.github.gavaconnectsdks.service.TccCheckerService;
import io.github.gavaconnectsdks.service.VatExemptionCheckerService;

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
