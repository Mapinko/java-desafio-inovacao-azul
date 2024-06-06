package com.desafioinovacaoazul.testeeco3.controller;


import com.desafioinovacaoazul.testeeco3.DTO.PostResponseDTO;
import com.desafioinovacaoazul.testeeco3.model.Post;
import com.desafioinovacaoazul.testeeco3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostResponseDTO> getAllPosts() {
        return postService.getAllPosts().stream()
                .map(post -> new PostResponseDTO(
                        post.getId(),
                        post.getUser().getId(),
                        post.getContent(),
                        post.getLikes(),
                        post.getImg(),
                        post.getCreatedAt(),
                        post.getUpdatedAt()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        PostResponseDTO responseDTO = new PostResponseDTO(
                post.getId(),
                post.getUser().getId(),
                post.getContent(),
                post.getLikes(),
                post.getImg(),
                post.getCreatedAt(),
                post.getUpdatedAt());
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public PostResponseDTO createPost(@RequestBody Post post) {
        Post savedPost = postService.createPost(post);
        return new PostResponseDTO(
                savedPost.getId(),
                savedPost.getUser().getId(),
                savedPost.getContent(),
                savedPost.getLikes(),
                savedPost.getImg(),
                savedPost.getCreatedAt(),
                savedPost.getUpdatedAt());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
