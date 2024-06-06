package com.fiap.desafio_inovacao_azul.service;

import com.fiap.desafio_inovacao_azul.exception.ResourceNotFoundException;
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
        // Gera um ID único manualmente se não estiver presente no corpo da requisição
        if (informativo.getId() == null) {
            informativo.setId(generateUniqueId());
        }
        return informativoRepository.save(informativo);
    }

    public List<Informativo> getAllInformativos() {
        return informativoRepository.findAll();
    }

    public Optional<Informativo> getInformativoById(Long id) {
        return Optional.ofNullable(informativoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Informativo não encontrado com o ID: " + id)));
    }

    public Informativo updateInformativo(Long id, Informativo informativoDetails) {
        Informativo informativo = informativoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Informativo não encontrado com o ID: " + id));
        informativo.setTitulo(informativoDetails.getTitulo());
        informativo.setConteudo(informativoDetails.getConteudo());
        informativo.setDataCriacao(informativoDetails.getDataCriacao());
        informativo.setAutor(informativoDetails.getAutor());
        informativo.setCategoria(informativoDetails.getCategoria());
        return informativoRepository.save(informativo);
    }

    public void deleteInformativo(Long id) {
        Informativo informativo = informativoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Informativo não encontrado com o ID: " + id));
        informativoRepository.delete(informativo);
    }

    private synchronized Long generateUniqueId() {
        // Aqui você pode implementar uma lógica para gerar IDs únicos
        return System.currentTimeMillis() % 100000000L; // Exemplo simples para garantir que não exceda o limite de 8 dígitos
    }
}
