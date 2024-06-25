package com.urs.bcknd_dashboard.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.urs.bcknd_dashboard.model.StatusResponse;

import static org.assertj.core.api.Assertions.assertThat;

class StatusControllerTest {

    @Test
    void getStatus_ReturnsCorrectResponse() {
        // Arrange
        StatusController controller = new StatusController();

        // Act
        ResponseEntity<StatusResponse> response = controller.getStatus();

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getStatus()).isEqualTo("Service is up and running!");
        assertThat(response.getBody().getContent()).isEqualTo("Some content");
    }
}