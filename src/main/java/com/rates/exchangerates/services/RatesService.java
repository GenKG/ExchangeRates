package com.rates.exchangerates.services;




import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rates.exchangerates.controllers.RatesClient;
import com.rates.exchangerates.model.LatestJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RatesService {
    private RatesClient ratesClient;

    @Autowired
    public RatesService(RatesClient ratesClient) {
        this.ratesClient = ratesClient;
    }


    public LatestJson<String, HashMap<String, Double>> getRates(String ratesName) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        LatestJson<String,HashMap<String,Double>> rates = objectMapper.readValue(ratesClient.getStatistic(), LatestJson.class);
        System.out.println(rates);
        for (Map.Entry<String,Double> ratesElement: rates.getRates().entrySet()){
           if (ratesElement.getKey().contains(ratesName)) System.out.println(ratesElement.getValue());
        }

        return rates;
    }
    private Integer diffCourse(Double courseNow){
        return null;
    }
}

