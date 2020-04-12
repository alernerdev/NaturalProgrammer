package com.pragmaticbitbucket.spring5tutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pragmaticbitbucket.spring5tutorial.domain.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
