/*TODO: create all methods for  Entries, deposits, payments, and reports

 */

package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Main method
    public class LedgerScreen {
        private TransactionOrganizer transactionOrganizer;

        //method
        public LedgerScreen(TransactionOrganizer transactionOrganizer) {
            this.transactionOrganizer = transactionOrganizer;
        }

        //method maybe rename display2
        public void display2() {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("\nWhat would you like to see?\n");
                System.out.println("A) All Entries");
                System.out.println("D) Deposits");
                System.out.println("P) Payments");
                System.out.println("R) Reports");
                System.out.println("H) Home");

                String userChoice = scanner.next();

                switch (userChoice.toLowerCase()) {
                    case "a":
                        displayAll();
                        break;
                    case "d":
                        displayDeposits();
                        break;
                    case "p":
                        displayPayments();
                        break;
                    case "r:":
                        //  Use report screen method here
                        break;
                    case "h":
                        return;
                    default:
                        System.out.println("Not a valid option. Please try again.");
                } //end of switch
            } //end of loop
        }// end of display method

    public void displayAll() {
        List<Transactions> transactions = transactionOrganizer.readEntries();
        Collections.reverse(transactions);

        if (transactions.isEmpty()) {
            System.out.println("No transactions to display.");
        } else {
            for (Transactions transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    public void displayDeposits() {
        List<Transactions> transactions = transactionOrganizer.readEntries();
        Collections.reverse(transactions);

        boolean hasDeposits = false;
        for (Transactions transaction : transactions) {
            if (transaction.getAmount() > 0) {
                System.out.println(transaction);
                hasDeposits = true;
            }
        }

        if (!hasDeposits) {
            System.out.println("No deposits to display.");
        }
    }

    public void displayPayments() {
        List<Transactions> transactions = transactionOrganizer.readEntries();
        Collections.reverse(transactions);

        boolean hasPayments = false;
        for (Transactions transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction);
                hasPayments = true;
            }
        }

        if (!hasPayments) {
            System.out.println("No payments to display.");
        }
    }

    }


