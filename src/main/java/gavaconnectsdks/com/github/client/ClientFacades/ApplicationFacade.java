package gavaconnectsdks.com.github.client.ClientFacades;

import gavaconnectsdks.com.github.dtos.requests.TccApplicationRequest;
import gavaconnectsdks.com.github.dtos.responses.TccApplicationResponse;
import gavaconnectsdks.com.github.exceptions.ValidationException;

public class ApplicationFacade {
        public TccApplicationResponse applyTaxComplianceCertificate(TccApplicationRequest tccApplicationRequest){
        if(tccApplicationRequest==null) throw new ValidationException("Request body cannot be null");

        return null;
    }
}
