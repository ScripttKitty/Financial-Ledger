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
    private ArrayList<Transactions> transList;

    //default constructor
    public TransactionOrganizer() {

        transList = new ArrayList<>();
    }


    //initializes transList and adds entries to it
    public void addTransaction(Transactions entry) {
        transList.add(entry);
        makeTransaction(transList);

    }


    //method
    public void makeTransaction(ArrayList<Transactions> list) {
        try (BufferedWriter bufWriter = new BufferedWriter ( new FileWriter("transactions.csv", true ))) {

            for (Transactions transaction : list) {
                //The join() method concatenates the elements and returns the string
              String  info = "\\|" +
                        transaction.getTransDate() +
                        transaction.getTransTime() +
                        transaction.getDescription() +
                        transaction.getVendor() +
                        transaction.getAmount();

                bufWriter.write(info + "\n");

                System.out.println(info);
            } //end of for loop
            bufWriter.close();

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
                    addTransaction(test);

               // } else {
                    //Fix
                  //  System.out.println("Invalid data provided.");
              //  }
            } //end of while loop
            transFileReader.close();

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

