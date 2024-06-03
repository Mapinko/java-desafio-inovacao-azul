package com.fiap.desafio_inovacao_azul.controller;

import com.fiap.desafio_inovacao_azul.service.ExternoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/externo")
public class ExternoController {
    @Autowired
    private ExternoService externoService;

    @GetMapping("/cep/{cep}")
    public String buscarEnderecoPorCep(@PathVariable String cep) {
        return externoService.buscarEnderecoPorCep(cep);
    }

    @GetMapping("/qualidade-ar")
    public String buscarQualidadeDoArPorCidade(@RequestParam String cidade) {
        return externoService.buscarQualidadeDoArPorCidade(cidade);
    }
}
