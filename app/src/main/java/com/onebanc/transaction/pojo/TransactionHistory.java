package com.onebanc.transaction.pojo;

import java.util.List;

public class TransactionHistory {
    private int userId;
    private int receipeintId;
    private List<Transaction> transactions;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReceipeintId() {
        return receipeintId;
    }

    public void setReceipeintId(int receipeintId) {
        this.receipeintId = receipeintId;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "userId=" + userId +
                ", receipeintId=" + receipeintId +
                ", transactions=" + transactions +
                '}';
    }
}
