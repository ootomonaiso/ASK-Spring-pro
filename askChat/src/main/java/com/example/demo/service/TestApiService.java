package com.example.demo.service;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestApiService {

    private final RestTemplate restTemplate;

    public TestApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getMostRelevantCategory(String question) {
        String url = "http://localhost:5000/api/find-relevant-category";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        String requestBody = "{\"question\": \"" + question + "\"}";
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);
        
        // JSONから最も関連するカテゴリを取得
        return (String) response.getBody().get("most_relevant_category");
    }
}
