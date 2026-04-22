package gavaconnectsdks.com.github.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.dtos.StationData;

public class KnowKraOfficeResponse {
    @JsonProperty(value="ResponseCode")
    private  String responseCode;

    @JsonProperty(value="Message")
    private String message;

    @JsonProperty(value="Status")
    private String status;

    @JsonProperty(value="STATIONDATA")
    private StationData stationData;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setStationData(StationData stationData) {
        this.stationData = stationData;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public StationData getStationData() {
        return this.stationData;
    }

    public String getStatus() {
        return this.status;
    }

    
}
