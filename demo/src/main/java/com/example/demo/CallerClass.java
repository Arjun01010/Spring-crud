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

        String responseObj = restTemplate.getForObject(localSlowServiceEndpoint, String.class);

        return CompletableFuture.completedFuture(responseObj);
    }

    @Async
    public CompletableFuture<String> callOther1Service() {
        String anotherEndpoint = "http://localhost:8082";
        String responseObj1 = restTemplate.getForObject(anotherEndpoint, String.class);
        return CompletableFuture.completedFuture(responseObj1);
    }

    @Async
    public CompletableFuture<String> callAPICalls(int i) {
        int add = 7840 + i;
        String isbnNumber = String.valueOf(add);
        String anotherEndpoint = "http://localhost:8082/isbn/"+isbnNumber;
        String responseObj1 = restTemplate.getForObject(anotherEndpoint, String.class);
        return CompletableFuture.completedFuture(responseObj1);
    }


}