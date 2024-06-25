package com.urs.bcknd_dashboard.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class ApiService {
    private final RestTemplate restTemplate;
    private final String url = "https://gist.githubusercontent.com/emamut/6626d3dff58598b624a1/raw/166183f4520c4603987c55498df8d2983703c316/provincias.json";
    private Map<String, Object> cachedResponse = null;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> fetchProvincesAPI() {
        if (cachedResponse == null) {
            try {
                byte[] responseBytes = restTemplate.getForObject(url, byte[].class);
                if (responseBytes != null) {
                    String response = new String(responseBytes, StandardCharsets.UTF_8);
                    ObjectMapper mapper = new ObjectMapper();
                    cachedResponse = mapper.readValue(response, Map.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cachedResponse;
    }
}