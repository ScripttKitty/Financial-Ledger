package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transactions {


    //variables
    private LocalDate transDate;
    private LocalTime transTime;
    private String description;
    private String vendor;
    private double amount;

    //Parameterized constructor
    public Transactions(LocalDate transDate, LocalTime transTime, String description, String vendor, Double amount) {
        this.transDate = transDate;
        this.transTime = transTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalDate getTransDate() {
        return transDate;
    }


    public LocalTime getTransTime() {
        return transTime;
    }


    public String getDescription() {
        return description;
    }


    public String getVendor() {
        return vendor;
    }


    public double getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        return
                transDate +
                        " | " + transTime +
                        " | " + description +
                        " | " + vendor +
                        " | " + amount;
    }
}
