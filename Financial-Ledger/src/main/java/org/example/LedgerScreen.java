/*TODO: create all methods for  Entries, deposits, payments, and reports

 */

package org.example;
import java.util.Scanner;

//Main method
    public class LedgerScreen {
        private static TransactionOrganizer transactionOrganizer;

        //method
        public LedgerScreen(TransactionOrganizer transactionOrganizer) {
            this.transactionOrganizer = transactionOrganizer;
        }

        //method maybe rename display2
        public static void display2() {
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

                switch (userChoice) {
                    case "A","a":
                        // Use display all entries method here
                        transactionOrganizer.displayAll();
                        break;
                    case "D","d":
                        // Use display deposits method here
                        transactionOrganizer.displayDeposits();
                        break;
                    case "P","p":
                        // Use display payments method here
                        transactionOrganizer.displayPayments();
                        break;
                    case "R", "r:":
                        //  Use report screen method here
                        break;
                    case "H", "h":
                        return;
                    default:
                        System.out.println("Not a valid option. Please try again.");
                } //end of switch
            } //end of loop
        }
    }


