package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        LocalDate currentDate = LocalDate.now();
//        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("|yyyy-MM-dd | HH:mm:ss| \n");
        String formattedDateTime = currentDateTime.format(formatter);

        boolean running = true;

        while(running){
            System.out.println(formattedDateTime + "Welcome! Please select an option: ");
            System.out.println("1: Make a deposit.");
            System.out.println("2: Make a payment.");
            System.out.println("3: View the ledger.");
            System.out.println("4: View current balance.");
            System.out.println("5: Exit the app.");

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
                                displayAllEntries();
                                break;
                            case 2:
                                displayDeposits();
                                break;
                            case 3:
                                displayPayments();
                                break;
                            case 4:
                                displayReports();
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
                    boolean viewBalance = true;
                    displayCurrentBalance();
                    System.out.println("1: Exit to homescreen");
                    viewBalance = false;//false to close loop back to homescreen
                    break;

                case 5:
                    System.out.println("Exiting the app...");

                    running = false; //setting to false closes the loop
                    break;

                default:
                    System.out.println("Invalid input, please try again.");
            }
        }
        scanner.close();
    }
    //methods that will be called within the ledger switch statement to split up code for readability

    public static void displayCurrentBalance(){
        double currentDeposits = 8000; //placeholder value
        double currentPayments = 2500; //placeholder value
        double currentBalance = currentDeposits - currentPayments;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("|yyyy-MM-dd | HH:mm:ss| \n");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        System.out.println("Current balance: $" + currentBalance);
    }

        public static void displayAllEntries() {
            System.out.println("Displaying all ledger entries...");
        //actually list entries from an ArrayList
    }

        public static void displayDeposits() {
            System.out.println("Displaying deposit entries...");
        //list only deposits
            String[] deposits = {"123.23", "2414.32", "2434.24", "2532.35"};
            for (String deposit : deposits) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("|yyyy-MM-dd | HH:mm:ss| \n");
                String formattedDateTime = LocalDateTime.now().format(formatter);
                double depositAmount = parseDouble(deposit);
                System.out.println("$" + depositAmount + "\n" + formattedDateTime);
            }
    }

        public static void displayPayments() {
            System.out.println("Displaying payment entries...");
        //list only payments
    }

        public static void displayReports() {
            System.out.println("Displaying financial reports...");
        //generate some reports (totals, averages, etc.), need to be searchable...

    }

}