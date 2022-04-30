package com.pfa.digitalbankingpfa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class Client {

    private Long id;
    private String cin;
    private String nom;
    private String prenom;
    private String eMail;
    private List<BankAccount> accounts;
}
