package com.pluralsight;

import java.io.*;
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
                    System.out.print("Enter deposit amount: ");
                    double deposit = scanner.nextDouble();
                    writeTransaction(deposit, scanner); // positive amount
                    System.out.println("Your deposit of $" + deposit + " is complete.");
                    break;

                case 2:
                    System.out.print("Enter your payment amount: ");
                    double payment = scanner.nextDouble();
                    writeTransaction(-payment, scanner); // negative amount
                    System.out.println("Your payment of $" + payment + " is complete.");
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("|yyyy-MM-dd | HH:mm:ss|\n");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        System.out.println("Current balance: $" + currentBalance);
    }
                //THIS IS STILL NOT WORKING PROPERLY
        //DISPLAY ALL ENTRIES
        public static void displayAllEntries() {
            System.out.println("Displaying all ledger entries...");
            System.out.println("Type | Amount | Date");

            try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\AlexJ\\pluralsight\\capstone-1\\AccountLedger\\src\\main\\java\\com\\pluralsight\\transactions.csv"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 5) {
                        String date = parts[0];
                        String time = parts[1];
                        String description = parts[2];
                        String vendor = parts[3];
                        String amount = parts[4];

                        System.out.printf("%-8s | %-6s | %-15s | %-8s | %5s\n",
                                date, time, description, vendor, amount);
                    }else {
                        System.out.println("System malfunction!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error reading transactions: " + e.getMessage());
            }
        }


                //HAVE TO ADD A WAY TO ACCESS DEPOSITS IN LEDGER
        //DISPLAY DEPOSITS
        public static void displayDeposits() {
            System.out.println("Displaying deposit entries...");
            try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
                readingFile(reader);
            } catch (Exception e) {
                System.out.println("Error reading deposits: " + e.getMessage());
            }
        }
                //HAVE TO ADD A WAY TO ACCESS PAYMENTS IN LEDGER
        //DISPLAY PAYMENTS
        public static void displayPayments() {
            System.out.println("Displaying payment entries...");
            try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
                readingFile(reader);
            } catch (Exception e) {
                System.out.println("Error reading payments: " + e.getMessage());
            }
    }
        //DISPLAY REPORTS
        public static void displayReports() {
            System.out.print("Search Reports: ");
        //generate some reports (totals, averages, etc.), need to be searchable...
            LocalDateTime now = LocalDateTime.now();

            try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
                readingFile(reader);
            } catch (Exception e) {
                System.out.println("Error reading payments: " + e.getMessage());
                System.out.println("Displaying financial reports...");
            }


    }
    //READ CSV FILE
    public static void readingFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");

            if (parts.length == 5) {
                String date = parts[0].trim();
                String time = parts[1].trim();
                String description = parts[2].trim();
                String vendor = parts[3].trim();
                double amount = Double.parseDouble(parts[4].trim());

                if (amount > 0) {
                    System.out.printf("%-8s | %-6s | %-10s | %-8s | %5s\n",
                            date, time, description, vendor, amount);
                }
            }
        }
    }
    //WRITE TRANSACTION
    public static void writeTransaction(double amount, Scanner scanner) {
        LocalDateTime now = LocalDateTime.now();
        String date = now.toLocalDate().toString();
        String time = now.toLocalTime().withNano(0).toString(); // Remove nanoseconds

        scanner.nextLine(); // Clear the buffer

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\AlexJ\\pluralsight\\capstone-1\\AccountLedger\\src\\main\\java\\com\\pluralsight\\transactions.csv", true))) {
            String line = String.format("%-8s|%-6s|%s|%-4s|%.2f", date, time, description, vendor, amount);
            writer.write(line);
            writer.newLine();
            System.out.println("Transaction recorded");
        } catch (Exception e) {
            System.out.println("Error writing transaction: " + e.getMessage());
        }

    }
}