package com.example.ebankingbackend.services;

import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.entities.CurrentAccount;
import com.example.ebankingbackend.entities.SavingAccount;
import com.example.ebankingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void consulter() {
        BankAccount bankAccount = bankAccountRepository.findById("3966c616-e554-458f-8013-ba17c26d9198").orElse(null);
        if (bankAccount != null) {
            System.out.println("******************************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("Overdraft:" + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Rate:" + ((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperationList().forEach(accountOperation -> {
                System.out.println(accountOperation.getType() + "\t" + accountOperation.getOperationDate() + "\t" + accountOperation.getAmount());
            });
        }
    }
}
