package com.pfa.digitalbankingpfa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CurrentAccount extends BankAccount{

    private double overDraft;
}
