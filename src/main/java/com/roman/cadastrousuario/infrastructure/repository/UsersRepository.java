package com.roman.cadastrousuario.infrastructure.repository;

import com.roman.cadastrousuario.infrastructure.entitys.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
