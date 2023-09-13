package com.theara.keycloakSecurity.SpringKeycloak.repository;

import com.theara.keycloakSecurity.SpringKeycloak.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String username);
}