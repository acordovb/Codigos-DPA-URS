package com.urs.bcknd_dashboard.runner;

import com.urs.bcknd_dashboard.service.ApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApiCallRunner implements CommandLineRunner {
    private final ApiService apiService;

    public ApiCallRunner(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void run(String... args) throws Exception {
        apiService.fetchProvincesAPI();
    }
}