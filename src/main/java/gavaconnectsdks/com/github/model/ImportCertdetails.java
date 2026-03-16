package gavaconnectsdks.com.github.model;

import  java.util.List;

public class ImportCertdetails {
    private String taxpayerName;
    private String pinNo;
    private List<ImportCertDetail> importCertDetails;

    public void setImportCertDetails(List<ImportCertDetail> importCertDetails) {
        this.importCertDetails = importCertDetails;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
    }

    public void setTaxpayerName(String taxpayerName) {
        this.taxpayerName = taxpayerName;
    }

    public List<ImportCertDetail> getImportCertDetails() {
        return this.importCertDetails;
    }

    public String getPinNo() {
        return this.pinNo;
    }

    public String getTaxpayerName() {
        return this.taxpayerName;
    }

    
}
