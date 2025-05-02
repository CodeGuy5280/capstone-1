package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {


    public LocalDate getDate() {
        return date;
    }

    public Transaction() {
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


    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;
    private String type;

    public Transaction(LocalDate d, LocalTime time, String description, String vendor, double amount) {
        this.date = d;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;

    }
    public String toFormattedString() {
        return String.format("%s | %s | %s | %s | %f",
                date, time, description, vendor, amount);
    }
}