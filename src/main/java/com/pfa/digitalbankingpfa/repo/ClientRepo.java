package com.pfa.digitalbankingpfa.repo;

import com.pfa.digitalbankingpfa.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {



    Page<Client> findByNomContains(String kw , Pageable paegable);
}
