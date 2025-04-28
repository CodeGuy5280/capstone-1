package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while(running){
            System.out.println("Welcome! Please select an option: ");
            System.out.println("1: Make a deposit.");
            System.out.println("2: Make a payment.");
            System.out.println("3: View the ledger.");
            System.out.println("4: Exit the app.");

            int selection = scanner.nextInt();

            switch (selection){
                case 1:
                    System.out.println("Enter deposit amount: ");
                    double deposit =scanner.nextDouble();
                    System.out.println("Your deposit of " + deposit + " is complete.");
                    break;

                case 2:
                    System.out.println("Enter your payment amount: ");
                    double payment  = scanner.nextDouble();
                    System.out.println("Your payment of " + payment + " is complete.");
                    break;

                case 3:
                    boolean viewLedger = true;
                    while (viewLedger) {
                        System.out.println("Ledger options: ");
                        System.out.println("1: Display all entries");
                        System.out.println("2: Display deposits");
                        System.out.println("3: Display payments");
                        System.out.println("4: Display reports");
                        System.out.println("5: Exit to homescreen");
                        int options = scanner.nextInt();
                        switch (options) {
                            case 1:
                                System.out.println("1: Display all entries");
                                break;
                            case 2:
                                System.out.println("2: Display deposits");
                                break;
                            case 3:
                                System.out.println("3: Display payments");
                                break;
                            case 4:
                                System.out.println("4: Display reports");
                                break;
                            case 5:
                                System.out.println("Exit to homescreen");
                                viewLedger = false;//false to close loop back to homescreen
                            default:
                                System.out.println("Returning to homescreen...\n");//new line added for separation in CLI
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting the app...");

                    running = false; //setting to false closes the loop
                    break;

                default:
                    System.out.println("Invalid input, please try again.");
            }

        }
    }
}