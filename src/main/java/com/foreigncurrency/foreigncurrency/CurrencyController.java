package com.foreigncurrency.foreigncurrency;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
// https://exchangerate.host/#/
@RestController
public class CurrencyController {

    private final WebClient webClient;

    public CurrencyController(WebClient.Builder webClientBuilder) {

        this.webClient = webClientBuilder.baseUrl("https://api.apilayer.com/exchangerates_data/")
                .build();
        // api key T3QmZiC3QVOZcs1u1pap3ZM3LAmlIZTT
    }

    @PostMapping("/api/v1/price")
    public Mono<String> getDummyData(@RequestBody Price price) {
        /*
         * String convertTo = price.getCurrency();
         * String euro = "EUR";
         * String amount = price.getPrice();
         */
        String convertTo =price.getCurrency();
        String euro = "EUR";
        String amount = price.getEuroPrice();

        return webClient.get().uri("convert?to=" + convertTo + "&from=" + euro + "&amount=" + amount)
                .header("apikey", "T3QmZiC3QVOZcs1u1pap3ZM3LAmlIZTT").retrieve().bodyToMono(String.class);
    }
}
