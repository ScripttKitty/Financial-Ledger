/*TODO:
    finish addTransaction method
 * Finish readAllEntries method
*/

package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.IOException;
import java.util.List;

//This class will contain methods to read from and write to the transactions.csv file
public class TransactionOrganizer {
    private List<Transactions> transList;


    public void addTransaction(Transactions entry){
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
            }
            ; //end of for
            fileWriter.write(info + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }// end of add transaction method

    //Read all entries method
    //  private static ArrayList<Transactions> readAllEntriesFromFile(String transactions) {
    //            ArrayList<Transactions> entries = new ArrayList<>();
    //            return entries;
    //        }

    //method need to fix a few things
    private static Transactions readEntryFromFile(String transaction) {
        Transactions entry1 = null; //test entry initialized
        BufferedReader transFileReader = null;
        try {
            transFileReader = new BufferedReader(new FileReader(("transactions.csv")));
            String transactionString = transFileReader.readLine();
            String[] transactionData = transactionString.split("\\|");


            LocalDate transDate = LocalDate.parse(transactionData[0]);
            LocalTime transTime = LocalTime.parse(transactionData[1]);
            String description = transactionData[2];
            String vendor = transactionData[3];
            Double amount = Double.parseDouble(transactionData[4]);

            entry1 = new Transactions(transDate.now(), transTime.now(), "vanilla mocha", "caribou coffee", 2.50); //test entry with param
            return entry1;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

