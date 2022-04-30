package com.pfa.digitalbankingpfa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cin;

    private String nom;

    private String prenom;

    private String eMail;

    @OneToMany(mappedBy = "client")
    private List<BankAccount> accounts;
}
