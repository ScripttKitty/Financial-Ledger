/*TODO: create all methods for  Entries, deposits, payments, and reports

 */

package org.example;

import java.util.Scanner;




    public class LedgerScreen {
        private TransactionManager transactionManager;

        public LedgerScreen(TransactionManager transactionManager) {
            this.transactionManager = transactionManager;
        }

        public void display() {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("What would you like to see?");
                System.out.println("A) All Entries");
                System.out.println("D) Deposits");
                System.out.println("P) Payments");
                System.out.println("R) Reports");
                System.out.println("H) Home");

                String userChoice = scanner.next();

                switch (userChoice) {
                    case "A","a":
                        // Use display all entries method here
                        break;
                    case "D","d":
                        // Use display deposits method here
                        break;
                    case "P","p":
                        // Use display payments method here
                        break;
                    case "R":
                        //  Use report screen method here
                        break;
                    case "H":
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }


