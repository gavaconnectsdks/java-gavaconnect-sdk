package gavaconnectsdks.com.github.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExciseLicenseDetail {
    private boolean isSmallBrewer;

    @JsonProperty(value="Status")
    private String status;

    @JsonProperty(value="ClassOfGoods")
    private String classOfGoods;

    @JsonProperty(value="ExciseLicenceNo")
    private String exciseLicenseNumber;

    @JsonProperty(value="DateOfIssue")
    private String dateOfIssue;

    public void setClassOfGoods(String classOfGoods) {
        this.classOfGoods = classOfGoods;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public void setExciseLicenceNumber(String exciseLicenseNumber) {
        this.exciseLicenseNumber = exciseLicenseNumber;
    }

    public void setIsSmallBrewer(boolean isSmallBrewer) {
        this.isSmallBrewer = isSmallBrewer;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClassOfGoods() {
        return this.classOfGoods;
    }

    public String getDateOfIssue() {
        return this.dateOfIssue;
    }

    public String getExciseLicenceNumber() {
        return this.exciseLicenseNumber;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isIsSmallBrewer() {
        return this.isSmallBrewer;
    }
    
}
