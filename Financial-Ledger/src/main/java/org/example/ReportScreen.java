package org.example;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

//Main method
public class ReportScreen {
    private TransactionOrganizer transactionOrganizer;

    //Parameterized Constructor
    public ReportScreen(TransactionOrganizer transactionOrganizer) {
        this.transactionOrganizer = transactionOrganizer;
    }

    //Display method which displays the ReportScreen
    public void display3() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("""           
                    \nWhich report would you like to display?\n
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
                    previousMonth();
                    break;
                case "3":
                    yearToDate();
                    break;
                case "4":
                    previousYear();
                    break;
                case "5":
                    searchByVendor();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Not a valid option. Please try again.");
            }
        }
    }

    //This method calls to a boolean method to display Month To Date transactions
    private void monthToDate() {
        ArrayList<Transactions> transactions = transactionOrganizer.readEntries();
        System.out.println("Month To Date: \n");

        for (Transactions x : transactions) {
            if (isMonthToDate(x)) {
                System.out.println(x);
            }
        }

    }

    //This method calls to a boolean method to display Previous Month transactions
    private void previousMonth() {
        ArrayList<Transactions> transactions = transactionOrganizer.readEntries();
        System.out.println("Previous Month:\n ");

        for (Transactions x : transactions) {
            if (isPreviousMonth(x)) {
                System.out.println(x);
            }
        }
    }

    //This method calls to a boolean method to display Year to Date transactions
    private void yearToDate() {
        ArrayList<Transactions> transactions = transactionOrganizer.readEntries();
        System.out.println("Year to Date:\n");

        for (Transactions x : transactions) {
            if (isYearToDate(x)) {
                System.out.println(x);
            }
        }
    }

    //This method calls to a boolean method to display Previous Year transactions
    private void previousYear() {
        ArrayList<Transactions> transactions = transactionOrganizer.readEntries();
        System.out.println("Previous Year:\n");

        for (Transactions x : transactions) {
            if (isPreviousYear(x)) {
                System.out.println(x);
            }
        }
    }

    //This method takes user input and matches it to any vendor in our transactions.csv file
    private void searchByVendor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter the name of a vendor: ");
        String vendor = scanner.nextLine();

        boolean found = false; //Added a flag to determine if there are any vendor matches
        ArrayList<Transactions> transactions = transactionOrganizer.readEntries();
        for (Transactions x : transactions) {
            if (x.getVendor().equalsIgnoreCase(vendor)) {
                System.out.println("Here are the reports for "
                        + vendor + "\n" + x);
                found = true; //flag is now true if there is a match
            }
        }
        if (!found) {
            System.out.println("There are no vendors with that name in our records.\n");
        }
    }

    //This method returns transactions with the specified dates
    private boolean isMonthToDate(Transactions transactions) {
        int currentYear = Year.now().getValue(); //getValue method turns a specified date into an integer
        int currentMonth = LocalDate.now().getMonthValue();

        return transactions.getTransDate().getYear() == currentYear //getYear() retrieves the year specified in transaction dates
                && transactions.getTransDate().getMonthValue() == currentMonth; //The == and && ensures that the calendar date matches our requirements
    }

    //This method determines the last months date and returns transactions that occur
    private boolean isPreviousMonth(Transactions transactions) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1); //The minusMonths(1) requires a number (of months) to subtract.
        //I used now() to get the current date and subtracted 1 month from it, giving us our results
        return transactions.getTransDate().getYear() == lastMonth.getYear() //ensuring the year is correct
                && transactions.getTransDate().getMonthValue() == lastMonth.getMonthValue(); //ensuring the month is correct
    }

    //This method returns Year to Date transactions
    private boolean isYearToDate(Transactions transactions) {
        int currentYear = Year.now().getValue();

        return transactions.getTransDate().getYear() == currentYear;
    }

    //This method returns Last Year's transactions
    private boolean isPreviousYear(Transactions transactions) {
        LocalDate lastYear = LocalDate.now().minusYears(1);

        return transactions.getTransDate().getYear() == lastYear.getYear();
    }

}


