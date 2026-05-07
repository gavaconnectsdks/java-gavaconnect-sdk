package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.ImportCertCheckerByPinRequest;
import io.github.gavaconnectsdks.dtos.responses.ImportCertCheckerByPinResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class ImportCertificateCheckerByPinService extends IService {
    
    public ImportCertificateCheckerByPinService(GavaConfig config,Auth auth){
        
        super(config, auth);
        this.endpoint="/cbc/checker/v1/importcertificate/num";

    }

    public ImportCertCheckerByPinResponse request(ImportCertCheckerByPinRequest request) throws IllegalAccessException,IOException,InterruptedException {
       try {
            ValidatorEngine.validate(request);
            ImportCertCheckerByPinResponse response=httpClient.post(this.endpoint, request, ImportCertCheckerByPinResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        } 
    }
    

    
}
