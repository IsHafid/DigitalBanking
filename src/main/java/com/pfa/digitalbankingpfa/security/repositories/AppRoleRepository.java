package com.pfa.digitalbankingpfa.security.repositories;

import com.pfa.digitalbankingpfa.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
