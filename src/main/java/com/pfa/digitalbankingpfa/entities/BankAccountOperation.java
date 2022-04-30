package com.pfa.digitalbankingpfa.entities;

import com.pfa.digitalbankingpfa.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class BankAccountOperation {
    private Long id;
    private Date opDate;
    private double amount;
    private OperationType type;
    private BankAccount account;


}
