package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //using main class to run program -> all function calling will be here to initiate that portion of the App depending on user input.

        //use local date.parse
        //credit -> in | debit -> out
        //create separate classes for in and out
        //display transactions
        //load -> add -> save (persistence of data)
        //newest first = loop backward (i--) .length--
        //be weary of using substrings for searching to allow partial search terms
        //look into personalizing the app for coloring of transactions, etc.

        //Integrate the homescreen into the Main Class, not use its own Class file.




    public class HomeScreen {
        Scanner scanner = new Scanner(System.in);

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


        public void appDeposit(){
            System.out.println("What amount would you like to deposit?: ");
            deposit = scanner.nextDouble();
            System.out.println(deposit);
        }


        public void appPayment(){
            System.out.println("What amount would you like to pay?: ");
            payment = scanner.nextDouble();
        }


        boolean appExit = true;
        public void appExit(){
            System.out.println(("Exit Application? (Y/N): "));
            if(appExit){
                System.out.println("Exiting Application.");

               scanner.close();

            }
        }

    }

}
}
