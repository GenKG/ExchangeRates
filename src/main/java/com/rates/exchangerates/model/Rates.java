package com.rates.exchangerates.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Rates<String,Double> {

    private Map<String,Double> arrRates;

}
