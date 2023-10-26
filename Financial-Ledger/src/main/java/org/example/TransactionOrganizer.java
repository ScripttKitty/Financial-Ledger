/*TODO:
    finish addTransaction method
 * Finish readAllEntries method
*/

package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//This class will contain methods to read from and write to the transactions.csv file
public class TransactionOrganizer {
    //declaring List
    private List<Transactions> transList;

    //default constructor
    public TransactionOrganizer() {

    }

    //initializes transList and adds entries to it
    public void addTransaction(Transactions entry) {

        if (transList == null) {
            transList = new ArrayList<>();
        }
        transList.add(entry);
        makeTransaction(transList);

    }


    //method
    public void makeTransaction(List<Transactions> transactionsList) {
        try (FileWriter fileWriter = new FileWriter("transactions.csv")) {
            String info = null;
            for (Transactions transaction : transactionsList) {
                //The join() method concatenates the elements and returns the string
                info = String.join(" | " +
                        transaction.getTransDate() +
                        transaction.getTransTime() +
                        transaction.getDescription() +
                        transaction.getVendor() +
                        transaction.getAmount());
            } //end of for loop

            fileWriter.write(info + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }// end of add transaction method


    //May need to change else statement
    public List<Transactions> readEntries() {

        try (BufferedReader transFileReader = new BufferedReader(new FileReader("transactions.csv"))) {
            String transactionString;
            while ((transactionString = transFileReader.readLine()) != null) {
                String[] transactionData = transactionString.split("\\|");

               // if (transactionData.length == 5) {
                    LocalDate transDate = LocalDate.parse(transactionData[0]);
                    LocalTime transTime = LocalTime.parse(transactionData[1]);
                    String description = transactionData[2];
                    String vendor = transactionData[3];
                    Double amount = Double.parseDouble(transactionData[4]);

                    // Creates a Transaction object and stores it
                    Transactions entry = new Transactions(transDate, transTime, description, vendor, amount);
                    transList.add(entry);
                    Transactions test = new Transactions(LocalDate.now(), LocalTime.now(), "pumpkin latte", "caribou coffee", 3.50);

               // } else {
                    //Fix
                    System.out.println("Invalid data provided.");
              //  }
            } //end of while loop
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transList;

    }//end of read entry


    public void displayAll(){
        List<Transactions> list = readEntries();
        Collections.reverse(list);

        for (Transactions transactions : list) {
            System.out.println(transactions);
        }

    }

    public void displayDeposits(){
        List<Transactions> list = readEntries();
        Collections.reverse(list);

        for (Transactions transactions: list){
            if(transactions.getAmount() > 0){
                System.out.println(transactions);
            }
        }

    }

    public void displayPayments(){
        List<Transactions> list = readEntries();
        Collections.reverse(list);

        for (Transactions transactions: list){
            if(transactions.getAmount() < 0){
                System.out.println(transactions);
            }
        }
    }


}

