package com.example.ebankingbackend.dtos;

import com.example.ebankingbackend.enums.AccountStatus;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data

public class SavingBankAccountDTO extends BankAccountDTO{
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;
}
