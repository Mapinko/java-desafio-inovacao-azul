package com.fiap.desafio_inovacao_azul.util;

import com.fiap.desafio_inovacao_azul.exception.ExternalApiException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class ExternalApiUtil {
    private final RestTemplate restTemplate = new RestTemplate();

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

    public String getAirQualityByCity(String city) {
        try {
            String apiKey = "YOUR_IQAIR_API_KEY"; // Substitua pela sua chave de API do IQAir
            URI uri = UriComponentsBuilder.fromUriString("http://api.airvisual.com/v2/city")
                    .queryParam("city", city)
                    .queryParam("key", apiKey)
                    .build()
                    .toUri();
            return restTemplate.getForObject(uri, String.class);
        } catch (Exception e) {
            throw new ExternalApiException("Erro ao buscar qualidade do ar pela cidade: " + e.getMessage());
        }
    }
}
