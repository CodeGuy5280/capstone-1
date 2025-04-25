package com.pluralsight;

public class Transactions {

    //transaction types are stored here, navigate from the ledger options

    //debits and credits go here
    //separate logic for each to return a value + or -
    //bank balance needs to have a method to add and subtract ++ or --
    //include search function of substrings to locate by name, value, or transaction #


    //try to condense the program in to two files using methods instead of trying to create a class for each type of method/function.

    public class Ledger {

        //Contains a comprehensive list of all transactions
        //includes reports

        String[] allTransactions;
        String[] allDeposits;
        String[] allPayments;
        String viewReports; //redirect to new menu of reports

    }
}
