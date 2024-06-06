package com.desafioinovacaoazul.testeeco3.service;


import com.desafioinovacaoazul.testeeco3.exception.ResourceNotFoundException;
import com.desafioinovacaoazul.testeeco3.model.Post;
import com.desafioinovacaoazul.testeeco3.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return Optional.ofNullable(postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found with the ID: " + id)));
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found with the ID: " + id));
        postRepository.delete(post);
    }
}
