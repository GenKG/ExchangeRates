package com.rates.exchangerates.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rates.exchangerates.model.LatestJson;
import com.rates.exchangerates.services.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;


@RestController
public class RatesController {

    private RatesService ratesService;

    @Autowired
    public RatesController(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @GetMapping("api/rates/{ratesName}")
    public LatestJson<String, HashMap<String, Double>> getJsonRates(@PathVariable String ratesName) throws JsonProcessingException {
       return ratesService.getRates(ratesName);

    }


}
