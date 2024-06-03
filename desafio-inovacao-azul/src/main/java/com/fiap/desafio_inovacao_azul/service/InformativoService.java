package com.fiap.desafio_inovacao_azul.service;

import com.fiap.desafio_inovacao_azul.model.Informativo;
import com.fiap.desafio_inovacao_azul.repository.InformativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformativoService {
    @Autowired
    private InformativoRepository informativoRepository;

    public Informativo createInformativo(Informativo informativo) {
        return informativoRepository.save(informativo);
    }

    public List<Informativo> getAllInformativos() {
        return informativoRepository.findAll();
    }

    public Optional<Informativo> getInformativoById(Long id) {
        return informativoRepository.findById(id);
    }

    public Informativo updateInformativo(Long id, Informativo informativoDetails) {
        Informativo informativo = informativoRepository.findById(id).orElseThrow(() -> new RuntimeException("Informativo not found"));
        informativo.setTitulo(informativoDetails.getTitulo());
        informativo.setConteudo(informativoDetails.getConteudo());
        informativo.setDataCriacao(informativoDetails.getDataCriacao());
        informativo.setAutor(informativoDetails.getAutor());
        informativo.setCategoria(informativoDetails.getCategoria());
        return informativoRepository.save(informativo);
    }

    public void deleteInformativo(Long id) {
        Informativo informativo = informativoRepository.findById(id).orElseThrow(() -> new RuntimeException("Informativo not found"));
        informativoRepository.delete(informativo);
    }
}
