package com.pfa.digitalbankingpfa.entities;

import com.pfa.digitalbankingpfa.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class BankAccount {
    private String id;
    private String rib;
    private double balance;
    private Date created;
    private AccountStatus status;
    private Client client;
    private List<BankAccountOperation> operations;




}
