package gavaconnectsdks.com.github.service;

import java.io.IOException;

import gavaconnectsdks.com.github.auth.Auth;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.dtos.requests.ImportCertCheckerByPinRequest;
import gavaconnectsdks.com.github.dtos.responses.ImportCertCheckerByPinResponse;
import gavaconnectsdks.com.github.utils.engine.ValidatorEngine;

public class ImportCertificateCheckerByPinService extends IService {
    
    public ImportCertificateCheckerByPinService(GavaConfig config,Auth auth){
        
        super(config, auth);
        this.endpoint="/cbc/checker/v1/importcertificate/num";

    }

    public ImportCertCheckerByPinResponse request(ImportCertCheckerByPinRequest request) throws IllegalAccessException,IOException,InterruptedException {
       try {
            ValidatorEngine.validate(request);
            String path=new StringBuilder(config.getEnvironment().getBaseUrl()).append(this.endpoint).toString();
            ImportCertCheckerByPinResponse response=httpClient.post(path, request, ImportCertCheckerByPinResponse.class, auth.getAuthorizationBearerHeader());
            return response;  
        } catch (IllegalAccessException|IOException|InterruptedException  e) {
            throw e;
        } 
    }
    

    
}
