package com.urs.bcknd_dashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urs.bcknd_dashboard.model.StatusResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class StatusController {

    @GetMapping("/status")
    public ResponseEntity<StatusResponse> getStatus() {
        String status = "Service is up and running!";
        String content = "Some content";

        StatusResponse response = new StatusResponse(status, content);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}