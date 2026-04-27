package gavaconnectsdks.com.github.client.ClientFacades;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.TccApplicationRequest;
import gavaconnectsdks.com.github.dtos.responses.TccApplicationResponse;
import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.service.TccApplicationService;

public class ApplicationFacade {
        private final GavaConfig config;
        private final Auth auth;

        public ApplicationFacade(GavaConfig config,Auth auth){
            this.config=config;
            this.auth=auth;
        }

        public TccApplicationResponse applyTaxComplianceCertificate(TccApplicationRequest tccApplicationRequest) throws IOException,InterruptedException,IllegalAccessException  {
        try {
              if(tccApplicationRequest==null) throw new ValidationException("Request body is required");
              TccApplicationService tccApplicationService=new TccApplicationService(this.config, this.auth);
              return tccApplicationService.request(tccApplicationRequest);
        } catch (IOException  | InterruptedException | IllegalAccessException  e) {
            throw e;
        }
    }
}
