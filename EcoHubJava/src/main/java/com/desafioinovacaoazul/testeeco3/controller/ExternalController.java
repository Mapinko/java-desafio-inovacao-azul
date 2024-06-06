package com.desafioinovacaoazul.testeeco3.controller;

import com.desafioinovacaoazul.testeeco3.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/external")
public class ExternalController {

    @Autowired
    private ExternalService externalService;

    @GetMapping("/cep/{cep}")
    public String getAddressByCep(@PathVariable String cep) {
        return externalService.getAddressByCep(cep);
    }

    @GetMapping("/air")
    public String getAirQualityByCity(@RequestParam String city, @RequestParam String state, @RequestParam String country) {
        return externalService.getAirQualityByCity(city, state, country);
    }
}