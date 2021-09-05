package com.rates.exchangerates.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "rates", url = "${api.url}")
public interface RatesClient {

    @GetMapping(value = "${api.url.getStatistics}")
    String getStatistic();

    @GetMapping(value ="${api.url.getStatisticsBefore}")
    String getStatisticBefore(@PathVariable String date);
}
