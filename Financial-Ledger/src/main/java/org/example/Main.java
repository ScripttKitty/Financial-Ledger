/**
 * Financial Ledger
 * @author Annie Santamaria
 * description: This application is used for storing, reading, sorting, and writing financial data. There are three different screens,
 * all with various options that the user can make. User input will be saved into a csv file.
 */

package org.example;

//main method
public class Main {
    public static void main(String[] args) {


        TransactionOrganizer transactionOrganizer = new TransactionOrganizer();
        HomeScreen homeScreen = new HomeScreen(transactionOrganizer);
        homeScreen.display();


    }

}









