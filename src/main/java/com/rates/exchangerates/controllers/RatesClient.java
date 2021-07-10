package com.rates.exchangerates.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "rates", url = "https://openexchangerates.org/")
public interface RatesClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/latest.json?app_id=13a32583aa2c4a38828efb823ff85120",produces = "application/json")
    String getStatistic();

    @RequestMapping(method = RequestMethod.GET, value ="/api/latest.json?app_id=13a32583aa2c4a38828efb823ff85120" )
    String getStatisticBefore();
}
