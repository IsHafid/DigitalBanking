package com.pfa.digitalbankingpfa.repo;

import com.pfa.digitalbankingpfa.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccRepo extends JpaRepository<BankAccount,String> {
}
