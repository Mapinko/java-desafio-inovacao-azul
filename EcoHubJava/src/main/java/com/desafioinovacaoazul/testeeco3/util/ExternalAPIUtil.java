package com.desafioinovacaoazul.testeeco3.util;

import com.desafioinovacaoazul.testeeco3.exception.ExternalApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class ExternalAPIUtil {

    private static final Logger logger = LoggerFactory.getLogger(ExternalAPIUtil.class);
    private final RestTemplate restTemplate = new RestTemplate();

    public String getApiResponse(String baseUrl, String city, String state, String country, String apiKey) {
        URI uri = UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("city", city)
                .queryParam("state", state)
                .queryParam("country", country)
                .queryParam("key", apiKey)
                .build()
                .toUri();

        try {
            String response = restTemplate.getForObject(uri, String.class);
            logger.info("API Response: {}", response);
            return response;
        } catch (HttpClientErrorException e) {
            logger.error("HTTP Error: Status Code - {}, Response Body - {}", e.getStatusCode(), e.getResponseBodyAsString());
            throw new ExternalApiException("HTTP Error: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error: {}", e.getMessage());
            throw new ExternalApiException("Error: " + e.getMessage());
        }
    }

    public String getViaCepAddress(String cep) {
        try {
            URI uri = UriComponentsBuilder.fromUriString("https://viacep.com.br/ws/{cep}/json/")
                    .buildAndExpand(cep)
                    .toUri();
            return restTemplate.getForObject(uri, String.class);
        } catch (Exception e) {
            throw new ExternalApiException("Erro ao buscar endereço pelo CEP: " + e.getMessage());
        }
    }
}