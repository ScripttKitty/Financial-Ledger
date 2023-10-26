//TODO: before finishing make sure to reformat code in all classes
//TODO: Add descriptions of each method's functionality, parameters, parameter types, and return types. IN PROPER FORMAT.



package org.example;

//main method
public class Main {
    public static void main(String[] args) {


        TransactionOrganizer transactionOrganizer = new TransactionOrganizer();
        HomeScreen homeScreen = new HomeScreen(transactionOrganizer);
        homeScreen.display();



    }

}









