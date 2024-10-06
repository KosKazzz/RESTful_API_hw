package com.kaz.demo.models;

import jakarta.persistence.*;


@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "account")
    private int account;

    @Column(name = "account_balance")
    private int account_balance;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


    public UserAccount(int account, int account_balance, User user) {
        this.account = account;
        this.user = user;
        this.account_balance = account_balance;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public UserAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(int account_balance) {
        this.account_balance = account_balance;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", account=" + account +
                ", account_balance=" + account_balance +
                ", user=" + user +
                '}';
    }
}
