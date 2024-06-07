package com.desafioinovacaoazul.testeeco3.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class PostResponseDTO {
    private Long id;
    private Long userId;
    private String content;
    private Integer likes;
    private String img;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PostResponseDTO(Long id, Long userId, String content, Integer likes, String img, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.likes = likes;
        this.img = img;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}