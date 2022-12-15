package com.foreigncurrency.foreigncurrency;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;




@Component
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        WebClient client = WebClient.create("https://jsonplaceholder.typicode.com/todos/1");
        Mono<String> currencyMono = client.get()
        .retrieve()
        .bodyToMono(String.class);

        currencyMono.subscribe(System.out::println);
    }
    
}
