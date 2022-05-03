package com.pfa.digitalbankingpfa;

import com.pfa.digitalbankingpfa.entities.BankAccountOperation;
import com.pfa.digitalbankingpfa.entities.Client;
import com.pfa.digitalbankingpfa.entities.CurrentAccount;
import com.pfa.digitalbankingpfa.entities.SavingAccount;
import com.pfa.digitalbankingpfa.enums.AccountStatus;
import com.pfa.digitalbankingpfa.enums.OperationType;
import com.pfa.digitalbankingpfa.repo.BankAccOperRepo;
import com.pfa.digitalbankingpfa.repo.BankAccRepo;
import com.pfa.digitalbankingpfa.repo.ClientRepo;
import com.pfa.digitalbankingpfa.security.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingPfaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBankingPfaApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }
    //@Bean
    CommandLineRunner start(ClientRepo CR
                            , BankAccOperRepo BAOR
                            , BankAccRepo BAR){
        return args ->{

            Stream.of("Hatim","Ismail","Mouad").forEach(name->{

                Client C = new Client();
                C.setNom(name);
                C.setEMail(name+"@gmail.com");
                CR.save(C);

            });
            CR.findAll().forEach(client -> {
                CurrentAccount currAcc = new CurrentAccount();
                currAcc.setId(UUID.randomUUID().toString());
                currAcc.setBalance(Math.random()*20000);
                currAcc.setCreated(new Date());
                currAcc.setStatus(AccountStatus.CREATED);
                currAcc.setClient(client);
                currAcc.setOverDraft(5000);
                BAR.save(currAcc);


                SavingAccount SVAcc = new SavingAccount();
                SVAcc.setId(UUID.randomUUID().toString());
                SVAcc.setBalance(Math.random()*20000);
                SVAcc.setCreated(new Date());
                SVAcc.setStatus(AccountStatus.CREATED);
                SVAcc.setClient(client);
                SVAcc.setInterestRate(2.5);
                BAR.save(SVAcc);
            });


        BAR.findAll().forEach(acc->{

            for (int i =0 ; i<15;i++){
                BankAccountOperation Opr = new BankAccountOperation();

                Opr.setAccount(acc);
                Opr.setAmount(Math.random()*5000);
                Opr.setOpDate(new Date());
                Opr.setType(Math.random()>0.5? OperationType.DEBIT : OperationType.CREDIT);
                BAOR.save(Opr);
            }

        });

        };
    }
    @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args-> {
            securityService.saveNewUser("hatim","1234","1234");
            securityService.saveNewUser("ismail","1234","1234");
            securityService.saveNewUser("mouad","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("hatim","USER");
            securityService.addRoleToUser("hatim","ADMIN");
            securityService.addRoleToUser("ismail","ADMIN");
            securityService.addRoleToUser("mouad","USER");
        };
    }
}

