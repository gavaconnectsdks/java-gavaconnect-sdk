package io.github.gavaconnectsdks.client.ClientFacades;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.TccApplicationRequest;
import io.github.gavaconnectsdks.dtos.responses.TccApplicationResponse;
import io.github.gavaconnectsdks.exceptions.ValidationException;
import io.github.gavaconnectsdks.service.TccApplicationService;

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
