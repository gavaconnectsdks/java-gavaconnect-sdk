package io.github.gavaconnectsdks.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PinData {
    @JsonProperty(value="KRAPIN")
    private String kraPin;

    @JsonProperty(value="TypeOfTaxpayer")
    private String typeOfTaxpayer;

    @JsonProperty(value="Name")
    private String name;

    @JsonProperty(value="StatusOfPIN")
    private String statusOfPin;

    public void setKraPin(String kraPin) {
        this.kraPin = kraPin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatusOfPin(String statusOfPin) {
        this.statusOfPin = statusOfPin;
    }

    public void setTypeOfTaxpayer(String typeOfTaxpayer) {
        this.typeOfTaxpayer = typeOfTaxpayer;
    }

    public String getKraPin() {
        return this.kraPin;
    }

    public String getName() {
        return this.name;
    }

    public String getStatusOfPin() {
        return this.statusOfPin;
    }

    public String getTypeOfTaxpayer() {
        return this.typeOfTaxpayer;
    }

}
