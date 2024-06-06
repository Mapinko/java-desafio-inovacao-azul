package com.desafioinovacaoazul.testeeco3.controller;

import com.desafioinovacaoazul.testeeco3.DTO.CommentResponseDTO;
import com.desafioinovacaoazul.testeeco3.model.Comment;
import com.desafioinovacaoazul.testeeco3.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<CommentResponseDTO> getAllComments() {
        return commentService.getAllComments().stream()
                .map(comment -> new CommentResponseDTO(
                        comment.getId(),
                        comment.getPost().getId(),
                        comment.getUser().getId(),
                        comment.getContent(),
                        comment.getCreatedAt(),
                        comment.getUpdatedAt()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDTO> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        CommentResponseDTO responseDTO = new CommentResponseDTO(
                comment.getId(),
                comment.getPost().getId(),
                comment.getUser().getId(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUpdatedAt());
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public CommentResponseDTO createComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.createComment(comment);
        return new CommentResponseDTO(
                savedComment.getId(),
                savedComment.getPost().getId(),
                savedComment.getUser().getId(),
                savedComment.getContent(),
                savedComment.getCreatedAt(),
                savedComment.getUpdatedAt());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}