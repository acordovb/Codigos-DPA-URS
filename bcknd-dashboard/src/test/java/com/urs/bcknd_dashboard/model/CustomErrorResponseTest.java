package com.urs.bcknd_dashboard.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomErrorResponseTest {

    @Test
    public void testCustomErrorResponse() {
        int expectedStatus = 404;
        String expectedMessage = "Not Found";

        CustomErrorResponse response = new CustomErrorResponse(expectedStatus, expectedMessage);

        assertEquals(expectedStatus, response.getStatus(), "The status should match the expected value");
        assertEquals(expectedMessage, response.getMessage(), "The message should match the expected value");
    }
}