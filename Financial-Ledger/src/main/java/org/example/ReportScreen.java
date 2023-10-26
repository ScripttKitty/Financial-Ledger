package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportScreen {
    private TransactionOrganizer transactionOrganizer;

    public ReportScreen(TransactionOrganizer transactionOrganizer) {
        this.transactionOrganizer = transactionOrganizer;
    }

    public void display3() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("""
                                        
                    Which report would you like to display?\n
                    1) Month To Date
                    2) Previous Month                    
                    3) Year to Date
                    4) Previous Year
                    5) Search by Vendor
                    0) Back
                    """);
            String userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    monthToDate();
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "0":
                    exit = true;
                    break;

                default:
                    System.out.println("Not a valid option. Please try again.");
            }
        } //end of while lop
    }//end of display3

    private void monthToDate() {
        ArrayList<Transactions> transactions = transactionOrganizer.readEntries();
        System.out.println("Month To Date: ");

        for(Transactions x : transactions ){
            if(isMonthToDate (x)){
                System.out.println(x);
            }
        }

    }

    private void previousMonth() {

    }

    private void yearToDate() {

    }

    private void previousYear() {
        ArrayList<Transactions> transactions = transactionOrganizer.readEntries();
        System.out.println("Previous Year:\n");

        for (Transactions x : transactions) {
            if (isPreviousYear(x)) {
                System.out.println(x);
            }
        }

    }

    private void searchByVendor() {

    }









    private boolean isMonthToDate(Transactions transactions){
        return;
    }


    private boolean isPreviousMonth(Transactions transactions){

    }

    private boolean isYearToDate(Transactions transactions){

    }

    private  boolean isPreviousYear(Transactions transactions){

    }


