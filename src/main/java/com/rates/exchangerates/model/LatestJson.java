package com.rates.exchangerates.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;


public class LatestJson<String,Rates> implements Serializable {
    private String disclaimer;
    private String license;
    private String timestamp;
    private String base;
    private Rates rates;

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }
}
