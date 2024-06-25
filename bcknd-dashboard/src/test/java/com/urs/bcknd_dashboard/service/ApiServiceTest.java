package com.urs.bcknd_dashboard.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class ApiServiceTest {

    private RestTemplate restTemplateMock;
    private ApiService apiService;

    @BeforeEach
    public void setUp() {
        restTemplateMock = mock(RestTemplate.class);
        apiService = new ApiService(restTemplateMock);
    }

    @Test
    public void testFetchProvincesAPI() throws Exception {
        // Configurar la respuesta simulada del RestTemplate
        String json = "{\"province\":\"TestProvince\"}";
        when(restTemplateMock.getForObject(anyString(), eq(String.class))).thenReturn(json);

        // Convertir manualmente la respuesta JSON en un Map para verificar
        ObjectMapper mapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
        Map<String, Object> expectedResponse = mapper.readValue(json, Map.class);

        // Primera llamada para verificar la respuesta y el uso del caché
        Map<String, Object> response = apiService.fetchProvincesAPI();
        assertEquals(expectedResponse, response, "La respuesta debe coincidir con la esperada");

        // Segunda llamada para verificar que se usa el caché
        response = apiService.fetchProvincesAPI();
        assertEquals(expectedResponse, response, "La respuesta debe venir del caché");

        // Verificar que el RestTemplate se llamó solo una vez
        verify(restTemplateMock, times(1)).getForObject(anyString(), eq(String.class));
    }
}