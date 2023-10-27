package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

//Main method
public class HomeScreen {
    private TransactionOrganizer transactionOrganizer;

    /*
This constructor allows the LedgerScreen instance to work with TransactionOrganizer
 for managing the transactions. You'll see various versions of this constructor
 throughout my classes.
 */
    public HomeScreen(TransactionOrganizer transactionOrganizer) {
        this.transactionOrganizer = transactionOrganizer;
    }

    //This method is used to display the home screen and saves user input under userChoice
    public void display() {
        Scanner scanner1 = new Scanner(System.in);

        boolean exit = false;

        //This while loop runs and displays the choices for the user
        while (!exit) {
            System.out.println("\nPlease select an option: \n");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            String userChoice = scanner1.next();

            switch (userChoice.toLowerCase()) {
                case "d":
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Enter the date in YYYY-MM-DD format: ");
                    String dateInput = scanner2.nextLine();
                    LocalDate date = LocalDate.parse(dateInput);
                    System.out.println("Enter the time in HH:MM:SS format: ");
                    String timeInput = scanner2.nextLine();
                    LocalTime time = LocalTime.parse(timeInput);
                    System.out.println("Enter a description: ");
                    String desc = scanner2.nextLine();
                    System.out.println("Enter the vendor name: ");
                    String vendor = scanner2.nextLine();
                    System.out.println("Enter the deposit amount: ");
                    Double amount = scanner2.nextDouble();

                    Transactions deposit = new Transactions(date, time, desc, vendor, amount);
                    transactionOrganizer.addTransaction(deposit);
                    break;

                case "p":
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Enter the date in YYYY-MM-DD format: ");
                    String dateInput2 = scanner3.nextLine();
                    LocalDate date2 = LocalDate.parse(dateInput2);
                    System.out.println("Enter the time in HH:MM:SS format: ");
                    String timeInput2 = scanner3.nextLine();
                    LocalTime time2 = LocalTime.parse(timeInput2);
                    System.out.println("Enter a description: ");
                    String desc2 = scanner3.nextLine();
                    System.out.println("Enter the vendor name: ");
                    String vendor2 = scanner3.nextLine();
                    System.out.println("Enter the amount paid in 1234.56 format:  ");
                    Double amount2 = scanner3.nextDouble();

                    Transactions payment = new Transactions(date2, time2, desc2, vendor2, -amount2);
                    transactionOrganizer.addTransaction(payment);
                    break;

                case "l":
                    LedgerScreen ledgerScreen = new LedgerScreen(transactionOrganizer);
                    ledgerScreen.display2();
                    break;

                case "x":
                    System.out.println("Thank you for using our services. Goodbye.");
                    exit = true;
                    break;

                default:
                    System.out.println("Not a valid option. Please try again.");
            }
        }
    }

    //Come back to this if there is time
    public boolean confirmDate() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to use today's date? Y/N");
        String confirmDate = scanner.nextLine();
        confirmDate.equalsIgnoreCase("y" + "yes");
        confirmDate.equalsIgnoreCase("n" + "no");

        if (confirmDate.equalsIgnoreCase("y")) {
            LocalDate today = LocalDate.now();
            return true;
        } else
            System.out.println("Please enter a custom date in YYYY-MM-DD format:");
        String customDate = scanner.nextLine();
        return false;
    }
}

