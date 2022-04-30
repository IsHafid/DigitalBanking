package com.pfa.digitalbankingpfa.repo;

import com.pfa.digitalbankingpfa.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {
}
