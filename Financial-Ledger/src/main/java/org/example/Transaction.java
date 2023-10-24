package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {


    //variables
    private LocalDate transDate;
    private LocalTime transTime;
    private String description;
    private String vendor;
    private double amount;

    //Parameterized constructor
    public Transaction(LocalDate transDate, LocalTime transTime, String description, String vendor, Double amount ) {
        this.transDate = transDate;
        this.transTime = transTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public static void addDeposit(){

    }


    @Override
    public String toString() {
        return "Transaction{" +
                "description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", amount=" + amount +
                ", transDate=" + transDate +
                ", transTime=" + transTime +
                '}';
    }
}
