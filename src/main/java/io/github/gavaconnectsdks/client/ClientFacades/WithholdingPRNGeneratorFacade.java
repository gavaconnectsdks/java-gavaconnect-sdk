package io.github.gavaconnectsdks.client.ClientFacades;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.IncomeTaxWithPRNRequest;
import io.github.gavaconnectsdks.dtos.requests.RentalIncomeWithhPRNRequest;
import io.github.gavaconnectsdks.dtos.requests.VatWithhPRNRequest;
import io.github.gavaconnectsdks.dtos.responses.WithholdingPRNResponse;
import io.github.gavaconnectsdks.exceptions.ValidationException;
import io.github.gavaconnectsdks.service.GenerateIncomeTaxWithholdingPRNService;
import io.github.gavaconnectsdks.service.GenerateRentalIncomeTaxWithholdingPRNService;
import io.github.gavaconnectsdks.service.GenerateVATWithholdingPRNService;

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
