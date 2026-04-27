package gavaconnectsdks.com.github.client.ClientFacades;

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
import gavaconnectsdks.com.github.dtos.requests.TccCheckerrequest;
import gavaconnectsdks.com.github.dtos.requests.VatExcemptionCheckerRequest;
import gavaconnectsdks.com.github.dtos.responses.CustDecStatusCheckerResponse;
import gavaconnectsdks.com.github.dtos.responses.ExciseLicenseCheckerByPinResponse;
import gavaconnectsdks.com.github.dtos.responses.ExciseLinenceCheckerByCertNoresponse;
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

public class CheckerFacade {
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

    public FetchTaxpayerObligationresponse checkTaxpayerObligations(FetchTaxpayerObligationRequest fetchTaxpayerObligationRequest ){
        if(fetchTaxpayerObligationRequest==null) throw new ValidationException("Request body cannot be null");

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
}
