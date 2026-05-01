package io.github.gavaconnectsdks.service;

import java.io.IOException;

import io.github.gavaconnectsdks.auth.Auth;
import io.github.gavaconnectsdks.config.GavaConfig;
import io.github.gavaconnectsdks.dtos.requests.ImportCertificateCheckerRequest;
import io.github.gavaconnectsdks.dtos.responses.ImportCertificateCheckerResponse;
import io.github.gavaconnectsdks.utils.engine.ValidatorEngine;

public class ImportCertificateCheckerByCertService extends IService {

    public ImportCertificateCheckerByCertService(GavaConfig config,Auth auth){
        super(config, auth);
        this.endpoint="/cbc/checker/v1/importcertificate/num";
    }

    public ImportCertificateCheckerResponse request(ImportCertificateCheckerRequest request) throws IllegalAccessException,IOException,InterruptedException {
       try {
            ValidatorEngine.validate(request);
    
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            ImportCertificateCheckerResponse response=httpClient.post(path, request, ImportCertificateCheckerResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        } 
    }
    
}
