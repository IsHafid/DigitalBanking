package com.pfa.digitalbankingpfa.security.repositories;

import com.pfa.digitalbankingpfa.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
