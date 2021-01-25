package com.company.command;

import com.company.Customers;

public class PrintNameCommand implements Command {

    Customers customers;

    public PrintNameCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.PrintName();
    }
}