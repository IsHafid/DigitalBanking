package com.pfa.digitalbankingpfa.entities;

import com.pfa.digitalbankingpfa.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4,discriminatorType = DiscriminatorType.STRING)
@Data @NoArgsConstructor @AllArgsConstructor
public class BankAccount {

    @Id
    private String id;

    private String rib;

    private double balance;

    private Date created;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private List<BankAccountOperation> operations;




}
