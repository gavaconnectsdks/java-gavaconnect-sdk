package gavaconnectsdks.com.github.client.ClientFacades;

import gavaconnectsdks.com.github.dtos.requests.IncomeTaxWithPRNReequest;
import gavaconnectsdks.com.github.dtos.requests.RentalIncomeWithhPRNRequest;
import gavaconnectsdks.com.github.dtos.requests.VatWithhPRNRequest;
import gavaconnectsdks.com.github.dtos.responses.WithholdingPRNResponse;
import gavaconnectsdks.com.github.exceptions.ValidationException;

public class WithholdingPRNGeneratorFacade {
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
