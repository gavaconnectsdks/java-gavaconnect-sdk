package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.ImportCertCheckerByPinRequest;
import gavaconnectsdks.com.github.dtos.responses.ImportCertificateCheckerResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class ImportCertificateCheckerByPinService extends IService {
    
    public ImportCertificateCheckerByPinService(GavaConfig config,GavaClient.Auth auth){
        
        super(config, auth);
        this.endpoint="/cbc/checker/v1/importcertificate/num";

    }

    public ImportCertificateCheckerResponse request(ImportCertCheckerByPinRequest request) throws IllegalAccessException,IOException,InterruptedException {
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
