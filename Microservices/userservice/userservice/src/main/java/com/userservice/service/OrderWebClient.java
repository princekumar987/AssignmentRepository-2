package com.userservice.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class OrderWebClient {

    private final WebClient webClient;

    public OrderWebClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://orderservice").build();
    }


    public List<String> getOrder(int id) {
        System.out.println("WebClient");
        return webClient.get()
                .uri("/order/order/{id}", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {}) // ✅ real List<String>
                .block();
    }



}
