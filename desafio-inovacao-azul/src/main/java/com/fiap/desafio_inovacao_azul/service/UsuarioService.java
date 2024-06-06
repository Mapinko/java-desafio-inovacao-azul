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
        usuario.setId(generateUniqueId());
        validateUsuario(usuario);
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
        validateUsuario(usuario); // Adicione a validação aqui para garantir que todos os campos obrigatórios estão preenchidos
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));
        usuarioRepository.delete(usuario);
    }

    private void validateUsuario(Usuario usuario) {
        if (usuario.getNomeUsuario() == null || usuario.getNomeUsuario().isEmpty()) {
            throw new IllegalArgumentException("Nome de usuário não pode ser nulo ou vazio");
        }
        if (usuario.getNomeUsuario().length() > 10) {
            throw new IllegalArgumentException("Nome de usuário excede o tamanho máximo de 10 caracteres");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }
        if (usuario.getEmail().length() > 255) {
            throw new IllegalArgumentException("Email excede o tamanho máximo de 255 caracteres");
        }
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser nula ou vazia");
        }
        if (usuario.getSenha().length() > 20) {
            throw new IllegalArgumentException("Senha excede o tamanho máximo de 20 caracteres");
        }
        if (usuario.getNomeCompleto() == null || usuario.getNomeCompleto().isEmpty()) {
            throw new IllegalArgumentException("Nome completo não pode ser nulo ou vazio");
        }
        if (usuario.getNomeCompleto().length() > 200) {
            throw new IllegalArgumentException("Nome completo excede o tamanho máximo de 200 caracteres");
        }
        if (usuario.getDataNascimento() == null) {
            throw new IllegalArgumentException("Data de nascimento não pode ser nula");
        }
        if (usuario.getTelefone() == null || usuario.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode ser nulo ou vazio");
        }
        if (usuario.getTelefone().length() > 15) {
            throw new IllegalArgumentException("Telefone excede o tamanho máximo de 15 caracteres");
        }
    }

    private synchronized Long generateUniqueId() {
        return System.currentTimeMillis() % 100000000L; // Exemplo simples para garantir que não exceda o limite de 8 dígitos
    }
}
