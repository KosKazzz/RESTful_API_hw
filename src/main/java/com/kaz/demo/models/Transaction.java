package com.kaz.demo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "data")
    private Date date;// возможно придётся привратить в string
    //@Column(name = "debit_account")
    @ManyToOne
    @JoinColumn(name = "debit_account")
    //private int debit_account;
    private UserAccount userAccount;
    @Column(name = "target_account")
    private int target_account;
    @Column(name = "amount")
    private int amount;
    @Column(name = "type_of_operation")
    private TypeOfOperation type_of_operation; // возможно придётся привратить в string

    public Transaction(Date date, UserAccount userAccount, int target_account, int amount, TypeOfOperation type_of_operation) {
        this.date = date;
        this.userAccount = userAccount;
        this.target_account = target_account;
        this.amount = amount;
        this.type_of_operation = type_of_operation;
    }

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    /*    public int getDebit_account() {
        return debit_account;
    }

    public void setDebit_account(int debit_account) {
        this.debit_account = debit_account;
    }*/

    public int getTarget_account() {
        return target_account;
    }

    public void setTarget_account(int target_account) {
        this.target_account = target_account;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TypeOfOperation getType_of_operation() {
        return type_of_operation;
    }

    public void setType_of_operation(TypeOfOperation type_of_operation) {
        this.type_of_operation = type_of_operation;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", userAccount=" + userAccount +
                ", target_account=" + target_account +
                ", amount=" + amount +
                ", type_of_operation=" + type_of_operation +
                '}';
    }
}
