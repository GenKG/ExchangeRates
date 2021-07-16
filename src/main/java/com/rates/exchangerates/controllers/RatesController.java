package com.rates.exchangerates.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rates.exchangerates.model.LatestJson;
import com.rates.exchangerates.services.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;


@RestController
@RequestMapping(value = RatesController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RatesController {
    //TODO: добавить эндпоинт курса валюты в URL
    public static final String REST_URL = "/api/rates";

    private RatesService ratesService;

    @Value("${rates.name}")
    private String ratesName;

    @Autowired
    public RatesController(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @GetMapping
    public LatestJson<String, HashMap<String, Double>> greeting() throws JsonProcessingException {
       return ratesService.getRates(ratesName);

    }


}
