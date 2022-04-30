package com.pfa.digitalbankingpfa.repo;

import com.pfa.digitalbankingpfa.entities.BankAccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccOperRepo extends JpaRepository<BankAccountOperation,Long> {

}

