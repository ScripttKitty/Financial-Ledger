/*TODO: add deposit method
    add payment and deposit to CSV file

 */


package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

//main method
public class HomeScreen {
    private TransactionOrganizer transactionOrganizer;

    //THis method
    public HomeScreen(TransactionOrganizer transactionOrganizer) {
        this.transactionOrganizer = transactionOrganizer;
    }

    //This method is used to display the home screen and saves their input under userChoice
    public void display() {
        Scanner scanner2 = new Scanner(System.in);
        boolean exit = false;

        //This while loop runs and displays the choices for the user
        while (!exit) {
            System.out.println("Welcome! What would you like to do today?\n");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            String userChoice = scanner2.next();

            switch (userChoice) {
                case "D", "d":
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Enter the date in YYYY-MM-DD format: ");
                    String dateInput = scanner1.nextLine();
                    LocalDate date = LocalDate.parse(dateInput);
                    System.out.println("Enter the time in HH:MM:SS format: ");
                    String timeInput = scanner1.nextLine();
                    LocalTime time = LocalTime.parse(timeInput);
                    System.out.println("Enter a description: ");
                    String desc = scanner1.nextLine();
                    System.out.println("Enter the vendor name: ");
                    String vendor = scanner1.nextLine();
                    System.out.println("Enter the deposit amount: ");
                    Double amount = scanner1.nextDouble();

                    Transactions deposit = new Transactions(date, time, desc, vendor, amount);
                    transactionOrganizer.addTransaction(deposit);
                    break;
                case "P", "p":
                    System.out.println("Enter the date in YYYY-MM-DD format: ");
                    String dateInput2 = scanner2.nextLine();
                    LocalDate date2 = LocalDate.parse(dateInput2);
                    System.out.println("Enter the time in HH:MM:SS format: ");
                    String timeInput2 = scanner2.nextLine();
                    LocalTime time2 = LocalTime.parse(timeInput2);
                    System.out.println("Enter a description: ");
                    String desc2 = scanner2.nextLine();
                    System.out.println("Enter the vendor name: ");
                    String vendor2 = scanner2.nextLine();
                    System.out.println("Enter the amount paid: ");
                    Double amount2 = scanner2.nextDouble();

                    Transactions payment = new Transactions(date2, time2, desc2, vendor2, -amount2);
                    transactionOrganizer.addTransaction(payment);
                    break;
                case "L", "l":
                    // Implement the ledger
                    break;
                case "X", "x":
                    System.out.println("Thank you for using our services. Goodbye.");
                    exit = true;
                    break;
                default:
                    System.out.println("Not a valid option. Please try again.");
            }


        }

    }

    //method
    public void addDeposit() {
        Scanner scanner = new Scanner(System.in);
        //Transactions depositTransaction = new Transactions();


    }

    //method
    public static void makePayment() {
        //add it to the CSV file

    }


    //Come back to this if I have time
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

