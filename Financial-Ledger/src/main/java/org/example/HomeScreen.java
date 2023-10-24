package org.example;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class HomeScreen {
    private TransactionManager transactionManager;

    public HomeScreen(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    //This method is used to display the home screen and saves their input under userChoice
    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        //This while loop runs and displays the choices for the user
        while (!exit) {
            System.out.println("Welcome! What would you like to do today?\n");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            String userChoice = scanner.next();

            switch (userChoice) {
                case "D","d":
                    // use adding a deposit method
                    break;
                case "P","p":
                    // use a payment method here
                    break;
                case "L","l":
                    // Implement the ledger
                    break;
                case "X","x":
                    System.out.println("Thank you for using our services. Goodbye.");
                    exit = true;
                    break;
                default:
                    System.out.println("Not a valid option. Please try again.");
            }


        }

    }
    public void addDeposit() {
         Scanner scanner = new Scanner(System.in);
        //Transactions depositTransaction = new Transactions();


    }

     public static void  makePayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the date in YYYY-MM-DD format: ");
        String dateInput = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateInput);
        System.out.println("Please enter the time in HH:MM:SS format: ");
        String timeInput = scanner.nextLine();
        LocalTime time = LocalTime.parse(timeInput);
        System.out.println("What is this payment for? ");
        String desc = scanner.nextLine();
        System.out.println("Who did you pay this to? ");
        String vendor = scanner.nextLine();
        System.out.println("How much did you pay? ");
        Double amount = scanner.nextDouble();

        Transactions payment = new Transactions(date, time, desc, vendor, -amount);
       //.addTransaction(payment);

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

