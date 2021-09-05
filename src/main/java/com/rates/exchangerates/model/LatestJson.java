package com.rates.exchangerates.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class LatestJson<String,Rates> implements Serializable {

    private String disclaimer;

    private String license;

    private String timestamp;

    private String base;

    private Rates rates;

}
