package com.pluralsight;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = 100.0;
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to Your ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: $" + balance);
                    break;
                case 2:
                    balance = deposit(balance, scanner);
                    break;
                case 3:
                    balance = withdraw(balance, scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }
        }

        scanner.close();
    }

    public static double deposit(double currentBalance, Scanner scanner) {
        System.out.println("What amount would you like to deposit?: ");
        double deposit = scanner.nextDouble();

        while (deposit <= 0) {
            System.out.println("Invalid amount. Please enter a positive number:");
            deposit = scanner.nextDouble();
        }

        currentBalance += deposit;
        System.out.println("Deposit successful!");
        return currentBalance;
    }

    public static double withdraw(double currentBalance, Scanner scanner) {
        System.out.println("What amount would you like to withdraw?: ");
        double withdraw = scanner.nextDouble();

        while (withdraw <= 0 || withdraw > currentBalance) {
            if (withdraw <= 0) {
                System.out.println("Invalid amount. Please enter a positive number:");
            } else {
                System.out.println("Insufficient funds. Your balance is: $" + currentBalance);
            }
            withdraw = scanner.nextDouble();
        }

        currentBalance -= withdraw;
        System.out.println("Withdrawal successful!");
        return currentBalance;
    }
}
