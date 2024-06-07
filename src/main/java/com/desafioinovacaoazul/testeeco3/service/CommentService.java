package com.desafioinovacaoazul.testeeco3.service;

import com.desafioinovacaoazul.testeeco3.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.desafioinovacaoazul.testeeco3.model.Comment;
import com.desafioinovacaoazul.testeeco3.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        commentRepository.delete(comment);
    }
}