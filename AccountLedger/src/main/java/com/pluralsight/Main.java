package com.pluralsight;
//IMPORTS
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("|yyyy-MM-dd | HH:mm:ss| \n");
        String formattedDateTime = currentDateTime.format(formatter);

        boolean running = true;

        while(running){
            System.out.println(formattedDateTime + "Welcome! Please select an option: ");
            System.out.println("D: Make a deposit.");
            System.out.println("P: Make a payment.");
            System.out.println("L: View the ledger.");
            System.out.println("C: View current balance.");
            System.out.println("X: Exit the app.");

            String selection = scanner.next();

            switch (selection){
                case "d", "D":
                    System.out.print("Enter deposit amount: ");
                    double deposit = scanner.nextDouble();
                    writeTransaction(deposit, scanner); // positive amount
                    System.out.println("Your deposit of $" + String.format("%.2f", deposit) + " is complete.");
                    break;

                case "p", "P":
                    System.out.print("Enter your payment amount: ");
                    double payment = scanner.nextDouble();
                    writeTransaction(-payment, scanner); // negative amount
                    System.out.println("Your payment of $" + String.format("%.2f", payment) + " is complete.");
                    break;

                case "l", "L":
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
                                displayReports(scanner);

                                break;
                            case 5:
                                System.out.println("Exit to homescreen");
                                viewLedger = false;//false to close loop back to homescreen
                                break;
                            default:
                                System.out.println("Returning to homescreen...\n");//new line added for separation in CLI
                        }
                    }
                    break;

                case "c", "C":
                    boolean viewBalance = true;
                    displayCurrentBalance();
//                    System.out.println("1: Exit to homescreen");
                    viewBalance = false;//false to close loop back to homescreen
                    break;

                case "x", "X":
                    System.out.println("Exiting the app...");

                    running = false; //setting to false closes the loop
                    break;

                default:
                    System.out.println("Invalid input, please try again.");
            }
        }
        scanner.close();
    }

                //TODO: NOT MANDATORY ONLY HARD CODED BALANCE, UPDATE TO REALTIME
    public static void displayCurrentBalance(){
        double currentDeposits = 8000;//placeholder value
        double currentPayments = 2500; //placeholder value
        double currentBalance = currentDeposits - currentPayments;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("|yyyy-MM-dd | HH:mm:ss|\n");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        System.out.println("Current balance: $" + currentBalance);
    }
        //DISPLAY ALL ENTRIES
        public static void displayAllEntries() {
            System.out.println("Displaying all ledger entries...");

            try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 5) {
                        String date = parts[0];
                        String time = parts[1];
                        String description = parts[2];
                        String vendor = parts[3];
                        double amount = Double.parseDouble(parts[4]);


                        System.out.printf("%s | %s | %s | %s | %.2f\n",
                                date, time, description, vendor, amount);
                    }else {
                        System.out.println("System malfunction!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error reading transactions: " + e.getMessage());
            }
        }


                //TODO: HAVE TO ADD A WAY TO ACCESS DEPOSITS IN LEDGER
        //DISPLAY DEPOSITS
        public static void displayDeposits() {
            System.out.println("Displaying deposit entries...");
            ArrayList<Transaction> transactions = loadTransaction();
                readingFile(transactions, "Deposit");
        }

                //TODO: HAVE TO ADD A WAY TO ACCESS PAYMENTS IN LEDGER
        //DISPLAY PAYMENTS
        public static void displayPayments() {
            System.out.println("Displaying payment entries...");
            ArrayList<Transaction> transactions = loadTransaction();
            readingFile(transactions, "Payment");
        }



        //DISPLAY REPORTS
        //TODO: generate some reports (totals, averages, etc.), need to be searchable...
    public static void displayReports(Scanner scanner) {


        boolean viewReports = true;
        while (viewReports) {
            LocalDateTime now = LocalDateTime.now();
            System.out.println("Report options: ");
            System.out.println("1: Month To Date");
            System.out.println("2: Previous Month");
            System.out.println("3: Year To Date");
            System.out.println("4: Previous Year");
            System.out.println("5: Search by Vendor");
            System.out.println("0: Back");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                //TODO: ADD LOGIC FOR SEARCH: CURRENTMONTH, CURRENTDATE, PREVIOUSMONTH, CURRENTYEAR, PREVIOUSYEAR AND VENDOR NAME
                switch (choice) {
                    case 0:
                        viewReports = false;
                        break;
                    case 1:
                        System.out.println(/*currentMonth*/ "To" + /*currentDate*/ "report selected");
                        break;
                        // Implement report logic here
                    case 2:
                        System.out.println("Previous month selected"/*+ previousMonth*/);
                        break;
                    case 3:
                        System.out.println("Year to date selected" /*+ currentYear*/);
                        break;
                    case 4:
                        System.out.println("Previous year selected" /*+ previousYear*/);
                        break;
                    case 5:
                        System.out.println("Enter vendor name: "/*+ vendor name*/);
                        break;
                    // Add cases 2-5 similarly
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a number");
                scanner.nextLine();  // Clear invalid input
            }
        }
    }

    public static ArrayList<Transaction> loadTransaction(){
        ArrayList<Transaction> transactions = new ArrayList<>();
        try  {
                FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    LocalDate date = LocalDate.parse(parts[0]);
                    LocalTime time = LocalTime.parse(parts[1]);
                    String description = parts[2];
                    String vendor = parts[3];
                    double amount = Double.parseDouble(parts[4]);

                    Transaction transaction = new Transaction(date, time, description, vendor, amount);
                    transactions.add(transaction);
                }
            }
        }catch (IOException e){
            System.out.println("Error loading transaction reports" + e.getMessage());
        }
    return transactions;
    }

    //READ CSV FILE
    //TODO: FIX THE FILE READING LOGIN DUE TO ONLY PRINTING DEPOSIT
    public static void readingFile(ArrayList<Transaction> transactions, String typeFilter) {

        for (Transaction t : transactions) {
            if ("all".equalsIgnoreCase(typeFilter)
                    || ("Deposit".equalsIgnoreCase(typeFilter) && t.getAmount() > 0)
                    || ("Payment".equalsIgnoreCase(typeFilter) && t.getAmount() < 0)) {

                System.out.println(t.toFormattedString());
            }
        }
    }

    //WRITE TRANSACTION
    public static void writeTransaction(double amount, Scanner scanner) {
        LocalDateTime now = LocalDateTime.now();
        String date = now.toLocalDate().toString();
        String time = now.toLocalTime().withNano(0).toString();

        scanner.nextLine(); // Clear the buffer

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();

        //transaction type: deposit or payment
        String type = amount > 0 ? "Deposit" : "Payment";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true))) {

            String line = String.format("%s|%s|%s|%s|%.2f", date, time, description, vendor, amount);
            writer.write(line);
            writer.newLine();
            System.out.println("Transaction recorded: " + type);
        } catch (Exception e) {
            System.out.println("Error writing transaction: " + e.getMessage());
        }

    }
}
