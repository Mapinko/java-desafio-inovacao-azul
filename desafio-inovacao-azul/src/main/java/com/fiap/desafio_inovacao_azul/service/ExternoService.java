package com.fiap.desafio_inovacao_azul.service;

import com.fiap.desafio_inovacao_azul.util.ExternalApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternoService {
    @Autowired
    private ExternalApiUtil externalApiUtil;

    public String buscarEnderecoPorCep(String cep) {
        return externalApiUtil.getViaCepAddress(cep);
    }

    public String buscarQualidadeDoArPorCidade(String cidade) {
        return externalApiUtil.getAirQualityByCity(cidade);
    }
}
