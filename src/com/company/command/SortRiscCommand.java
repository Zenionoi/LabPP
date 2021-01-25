package com.company.command;

import com.company.Customers;

public class SortRiscCommand implements Command {

    Customers customers;

    public SortRiscCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.SortRisc();
    }
}