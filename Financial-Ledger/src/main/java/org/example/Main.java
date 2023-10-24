package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {


        //Welcome Screen
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! What would you like to do?");
        System.out.printf("D) Add Deposit\n" +
                                        "P) Make Payment\n" +
                                        "L) Open Ledger\n" +
                                        "X) Exit Application  ");
        String userInput = scanner.nextLine();

        //public static
/*
        switch(userInput) {
            case : userInput.equalsIgnoreCase("d");
            break

        }

 */


        //make an array list for transactions maybe call it entries?
        //use a switch statement

        Transaction entry1 = null; //test entry initialized
        BufferedReader transFileReader = null;
        try {
        transFileReader = new BufferedReader(new FileReader(("transactions.csv")));
        String transactionString = transFileReader.readLine();
        String[] transactionData = transactionString.split("\\|");
        LocalDate transDate = LocalDate.parse(transactionData[0]);
        LocalTime transTime = LocalTime.parse(transactionData[1]);
        String description = transactionData[2];
        String vendor = transactionData[3];
        Double amount = Double.parseDouble(transactionData[4]);

        entry1 = new Transaction(transDate.now(), transTime.now(), "vanilla mocha", "caribou coffee", 2.50 ); //test entry with param
        System.out.println(entry1);






        }



        catch(Exception e){

        }













        System.out.println("Hello world!");
    }
}