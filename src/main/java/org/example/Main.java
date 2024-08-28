package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Access Account");
            System.out.println("3. Sign out");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    bank.createAccount(name, password);
                    break;

                case 2:
                    System.out.print("Enter account holder name: ");
                    String accountName = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String accountPassword = scanner.nextLine();
                    Account account = bank.getAccount(accountName);

                    if (account != null && account.validatePassword(accountPassword)) {
                        while (true) {
                            System.out.println("\n1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Check Balance");
                            System.out.println("4. Logout");
                            System.out.print("Choose an option: ");
                            int accountChoice = scanner.nextInt();
                            switch (accountChoice) {
                                case 1:
                                    System.out.print("Enter amount to deposit: ");
                                    double depositAmount = scanner.nextDouble();
                                    account.deposit(depositAmount);
                                    break;

                                case 2:
                                    System.out.print("Enter amount to withdraw: ");
                                    double withdrawAmount = scanner.nextDouble();
                                    account.withdraw(withdrawAmount);
                                    break;

                                case 3:
                                    System.out.println("Current balance: $" + account.getBalance());
                                    break;

                                case 4:
                                    System.out.println("Logged out.");
                                    break;

                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                            }
                            if (accountChoice == 4) break;
                        }
                    } else {
                        System.out.println("Invalid account name or password.");
                    }
                    break;

                case 3:
                    System.out.println("Signing out...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}