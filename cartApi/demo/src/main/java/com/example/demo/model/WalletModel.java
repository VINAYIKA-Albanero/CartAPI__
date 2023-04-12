package com.example.demo.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "wallets")
public class WalletModel {
    @Id
    private String id;
    private double balance;
    private String userId;

    public WalletModel(String id, double balance, String userId) {
        this.id = id;
        this.balance = balance;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
// constructors, getters, and setters
}
