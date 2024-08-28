package org.example;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountHolderName, String password) {
        if (!accounts.containsKey(accountHolderName)) {
            accounts.put(accountHolderName, new Account(accountHolderName, password));
            System.out.println("Account created for " + accountHolderName);
        } else {
            System.out.println("Account already exists for " + accountHolderName);
        }
    }

    public Account getAccount(String accountHolderName) {
        return accounts.get(accountHolderName);
    }
}
