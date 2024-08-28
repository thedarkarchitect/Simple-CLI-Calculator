package org.example;

public class Account {
    private String accountHolderName;
    private String password;
    private double balance;

    public Account(String accountHolderName, String password) {
        this.accountHolderName = accountHolderName;
        this.password = password;
        this.balance = 0.0;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}
