package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

//THIS CLASS ENABLES FILTERING, FORMATTING, AND SEARCHING (EVENTUALLY)
//GETTERS AND SETTERS USED TO ACCESS AND CHANGE PRIVATE FIELDS
public class Transaction {


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    //ATTRIBUTES OF THE TRANSACTION OBJECT
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;
    private String type;

    //CREATES A NEW TRANSACTION OBJECT WITH THE LISTED VARIABLES
    public Transaction(LocalDate d, LocalTime time, String description, String vendor, double amount) {
        this.date = d;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    //FORMATS THE STRING OF TRANSACTION OBJECT
    public String toFormattedString() {
        return String.format("%s | %s | %s | %s | %.2f",
                date, time, description, vendor, amount);
    }
}