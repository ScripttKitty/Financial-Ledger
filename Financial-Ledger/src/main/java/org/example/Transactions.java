//TODO: delete any methods we do not need in the end

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

    public void setTransDate(LocalDate transDate) {
        this.transDate = transDate;
    }

    public LocalTime getTransTime() {
        return transTime;
    }

    public void setTransTime(LocalTime transTime) {
        this.transTime = transTime;
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

    //TODO: fix toString format
    @Override
    public String toString() {
        return "Transactions: " +
                "description= " + description + '\'' +
                ", vendor= " + vendor + '\'' +
                ", amount= " + amount +
                ", transDate= " + transDate +
                ", transTime= " + transTime +
                '}';
    }
}
