package com.pluralsight;

public class Main {

    //use local date.parse
    //credit -> in | debit -> out
    //create separate classes for in and out
    //display transactions
    //load -> add -> save (persistence of data)
    //newest first = loop backward (i--) .length--
    //be weary of using substrings for searching to allow partial search terms
    //look into personalizing the app for coloring of transactions, etc.
    public static void main(String[] args) {
        //using main class to run program -> all function calling will be here to initiate that portion of the App depending on user input.


        //Integrate the homescreen into the Main Class, not use its own Class file.


    }

    public static class HomeScreen {

        //each choice will navigate to a different screen of the program
        //options to direct to next app screen
        //D deposit
        //P make payment
        //L view ledger (option to other class)
        //exit the app
        double deposit;
        double payment;
        String Ledger;
        String Exit;


        public void setDeposit(){
            System.out.println("What amount would you like to deposit?: ");
        }


        public void setPayment(){
            System.out.println("What amount would you like to pay?: ");
        }



        public void setExit(){
            System.out.println("Confirming will exit the application. (Y/N): ");
        }

    }

}
