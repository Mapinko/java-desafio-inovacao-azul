package com.desafioinovacaoazul.testeeco3.repository;

import com.desafioinovacaoazul.testeeco3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}