package com.fiap.desafio_inovacao_azul.controller;

import com.fiap.desafio_inovacao_azul.model.Informativo;
import com.fiap.desafio_inovacao_azul.service.InformativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/informativos")
public class InformativoController {

    @Autowired
    private InformativoService informativoService;

    @PostMapping
    public Informativo createInformativo(@RequestBody Informativo informativo) {
        return informativoService.createInformativo(informativo);
    }

    @GetMapping
    public List<Informativo> getAllInformativos() {
        return informativoService.getAllInformativos();
    }

    @GetMapping("/{id}")
    public Optional<Informativo> getInformativoById(@PathVariable Long id) {
        return informativoService.getInformativoById(id);
    }

    @PutMapping("/{id}")
    public Informativo updateInformativo(@PathVariable Long id, @RequestBody Informativo informativoDetails) {
        return informativoService.updateInformativo(id, informativoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteInformativo(@PathVariable Long id) {
        informativoService.deleteInformativo(id);
    }
}