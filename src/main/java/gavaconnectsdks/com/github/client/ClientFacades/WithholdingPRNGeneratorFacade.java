package gavaconnectsdks.com.github.client.ClientFacades;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.IncomeTaxWithPRNRequest;
import gavaconnectsdks.com.github.dtos.requests.RentalIncomeWithhPRNRequest;
import gavaconnectsdks.com.github.dtos.requests.VatWithhPRNRequest;
import gavaconnectsdks.com.github.dtos.responses.WithholdingPRNResponse;
import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.service.GenerateIncomeTaxWithholdingPRNService;
import gavaconnectsdks.com.github.service.GenerateRentalIncomeTaxWithholdingPRNService;
import gavaconnectsdks.com.github.service.GenerateVATWithholdingPRNService;

public class WithholdingPRNGeneratorFacade {
    private final GavaConfig config;
    private final Auth auth;
    public WithholdingPRNGeneratorFacade(GavaConfig config,Auth auth){
        this.config=config;
        this.auth=auth;
    }
    public WithholdingPRNResponse generateIncomeTaxWithholdingPRN(IncomeTaxWithPRNRequest incomeTaxWithPRNReequest )throws IOException ,InterruptedException,IllegalAccessException{
        try {
                if(incomeTaxWithPRNReequest==null) throw new ValidationException("Request body is required.");
                GenerateIncomeTaxWithholdingPRNService generateIncomeTaxWithholdingPRNService=new GenerateIncomeTaxWithholdingPRNService(this.config, this.auth);
                return generateIncomeTaxWithholdingPRNService.request(incomeTaxWithPRNReequest);
        } catch (IOException|InterruptedException|IllegalAccessException e) {
            throw e;
        }

    }

    public WithholdingPRNResponse generateRentalWithholdingPRN(RentalIncomeWithhPRNRequest rentalIncomeWithhPRNRequest) throws  IOException ,InterruptedException,IllegalAccessException {
        try {
                if(rentalIncomeWithhPRNRequest==null) throw new ValidationException("Request body is required.");
                GenerateRentalIncomeTaxWithholdingPRNService generateRentalIncomeTaxWithholdingPRNService= new GenerateRentalIncomeTaxWithholdingPRNService(this.config, this.auth);
                return generateRentalIncomeTaxWithholdingPRNService.request(rentalIncomeWithhPRNRequest);
        } catch (IOException|InterruptedException|IllegalAccessException e) {
            throw e;
        }
 
    }

    public WithholdingPRNResponse generateVATWithholdingPRN(VatWithhPRNRequest vatWithhPRNRequest)throws  IOException ,InterruptedException,IllegalAccessException {
        try {
              if(vatWithhPRNRequest==null) throw new ValidationException("Request body is required.");
              GenerateVATWithholdingPRNService generateVATWithholdingPRNService=new GenerateVATWithholdingPRNService(this.config, this.auth);
              return generateVATWithholdingPRNService.request(vatWithhPRNRequest);
        } catch (IOException|InterruptedException|IllegalAccessException e) {
            throw e;
        }
      
    }

}
