package com.urs.bcknd_dashboard.service;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ApiServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private ApiService apiService;

    @SuppressWarnings("deprecation")
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        apiService = new ApiService(restTemplate);
    }

    @Test
    public void testFetchProvincesAPIReturnsData() throws Exception {
        // Preparar datos de prueba
        String mockResponse = "{\"key\":\"value\"}";
        byte[] mockResponseBytes = mockResponse.getBytes(StandardCharsets.UTF_8);
        when(restTemplate.getForObject(anyString(), eq(byte[].class))).thenReturn(mockResponseBytes);

        // Ejecutar
        Map<String, Object> result = apiService.fetchProvincesAPI();

        // Verificar
        assertNotNull(result);
        assertEquals("value", result.get("key"));
        verify(restTemplate, times(1)).getForObject(anyString(), eq(byte[].class));
    }

    @Test
    public void testClearCache() throws Exception {
        testFetchProvincesAPIReturnsData();

        apiService.clearCache();

        assertNull(apiService.getCachedResponse());
    }

    @Test
    public void testFetchProvincesAPIReturnsCachedData() throws Exception {
        testFetchProvincesAPIReturnsData();

        Map<String, Object> result = apiService.fetchProvincesAPI();

        assertNotNull(result);
        assertEquals("value", result.get("key"));
        verify(restTemplate, times(0)).getForObject(anyString(), eq(byte[].class));
    }
}