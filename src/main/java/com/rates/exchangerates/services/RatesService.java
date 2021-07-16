package com.rates.exchangerates.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rates.exchangerates.controllers.RatesClient;
import com.rates.exchangerates.model.LatestJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class RatesService {
    private RatesClient ratesClient;

    @Autowired
    public RatesService(RatesClient ratesClient) {
        this.ratesClient = ratesClient;
    }

    //TODO:залогировать исключение JsonProcessingException
    public LatestJson<String, HashMap<String, Double>> getRates(String ratesName) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        LatestJson<String,HashMap<String,Double>> rates = objectMapper.readValue(ratesClient.getStatistic(), LatestJson.class);
        for (Map.Entry<String,Double> ratesElement: rates.getRates().entrySet()){
           if (ratesElement.getKey().contains(ratesName)) {
               System.out.println(ratesElement.getValue());
                diffCourse(ratesElement.getValue(),ratesName);
           }
        }

        return rates;
    }
    //TODO:подумать о вынесении методов в абстракцию
    //Вычисление разницы курса валют по отношению к вчерашнему дню
    private double diffCourse(Double courseNow,String ratesName) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String yesterdayDate = getYesterdayDate();
        LatestJson<String,HashMap<String,Double>> rates = objectMapper.readValue(ratesClient.getStatisticBefore(yesterdayDate), LatestJson.class);
        double courseBefore = 0;
        for (Map.Entry<String,Double> ratesElement: rates.getRates().entrySet()){
            if (ratesElement.getKey().contains(ratesName)) {
                System.out.println(ratesElement.getValue());
                courseBefore = ratesElement.getValue();
            }
        }
        return courseNow - courseBefore;
    }

    //получение вчерашней даты в формате 2021-07-16.json
    private String getYesterdayDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(calendar.getTime()) + ".json";
    }
}

