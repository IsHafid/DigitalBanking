package com.pfa.digitalbankingpfa.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class SavingAccount extends BankAccount {

    private double interestRate;
}
