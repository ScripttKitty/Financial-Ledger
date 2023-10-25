/*TODO: add file writer
    finish addTransaction method
 * Finish readAllEntries method
 *
*/

package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

//This class will contain methods to read form and write to the transactions.csv file
public class TransactionOrganizer {

    //TODO: add file writer
    //method
    public void addTransaction(ArrayList<Transactions> transactions){
        //try (Writer)

    }

    //Read all entries method
    //  private static ArrayList<Transactions> readAllEntriesFromFile(String transactions) {
    //            ArrayList<Transactions> entries = new ArrayList<>();
    //            return entries;
    //        }

    //method
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
        //  catch (IOException e){
        //      throw new RuntimeException(e);
        //  }







    }
}

