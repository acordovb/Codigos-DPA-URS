package com.urs.bcknd_dashboard.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urs.bcknd_dashboard.model.CustomErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public ResponseEntity<?> error() {
        String errorMessage = "Esta es una ruta no válida. Por favor, verifique la URL e intente nuevamente.";
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(), errorMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}