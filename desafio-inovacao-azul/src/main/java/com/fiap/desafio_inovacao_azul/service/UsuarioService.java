package com.fiap.desafio_inovacao_azul.service;

import com.fiap.desafio_inovacao_azul.exception.ResourceNotFoundException;
import com.fiap.desafio_inovacao_azul.model.Usuario;
import com.fiap.desafio_inovacao_azul.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return Optional.ofNullable(usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id)));
    }

    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));
        usuario.setNomeUsuario(usuarioDetails.getNomeUsuario());
        usuario.setEmail(usuarioDetails.getEmail());
        usuario.setSenha(usuarioDetails.getSenha());
        usuario.setNomeCompleto(usuarioDetails.getNomeCompleto());
        usuario.setDataNascimento(usuarioDetails.getDataNascimento());
        usuario.setTelefone(usuarioDetails.getTelefone());
        usuario.setSeguindo(usuarioDetails.getSeguindo());
        usuario.setSeguidores(usuarioDetails.getSeguidores());
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));
        usuarioRepository.delete(usuario);
    }
}
