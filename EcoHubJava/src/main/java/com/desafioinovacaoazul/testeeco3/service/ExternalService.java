package com.desafioinovacaoazul.testeeco3.service;

import com.desafioinovacaoazul.testeeco3.util.ExternalAPIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class ExternalService {

    @Autowired
    private ExternalAPIUtil externalAPIUtil;

    private final String apiKey = "7f5dcef4-b3c3-416e-bac2-c75a2c10cff1";
    private final String baseUrl = "http://api.airvisual.com/v2/city";

    public String getAirQualityByCity(String city, String state, String country) {
        return externalAPIUtil.getApiResponse(baseUrl, city, state, country, apiKey);
    }

    public String getAddressByCep(String cep) {
        return externalAPIUtil.getViaCepAddress(cep);
    }
}