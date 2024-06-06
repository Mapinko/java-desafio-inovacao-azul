package com.desafioinovacaoazul.testeeco3.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private Integer followers;
    private Integer following;

    public UserResponseDTO(Long id, String username, String email, Integer followers, Integer following) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.followers = followers;
        this.following = following;
    }
}
