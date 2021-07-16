package com.rates.exchangerates.model;

import java.util.Map;

public class Rates<String,Double> {
    private Map<String,Double> arrRates;

    public Map<String, Double> getArrRates() {
        return arrRates;
    }

    public void setArrRates(Map<String, Double> arrRates) {
        this.arrRates = arrRates;
    }
}
