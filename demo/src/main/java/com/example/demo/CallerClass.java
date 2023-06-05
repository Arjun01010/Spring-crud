package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;


@Service
public class CallerClass {

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public CompletableFuture<String> callOtherService() {
        String localSlowServiceEndpoint = "http://localhost:8082/service";
        String anotherEndpoint = "http://localhost:8082";
        String responseObj = restTemplate.getForObject(localSlowServiceEndpoint, String.class);
        String responseObj1 = restTemplate.getForObject(anotherEndpoint, String.class);
        return CompletableFuture.completedFuture(responseObj+responseObj1);
    }
}