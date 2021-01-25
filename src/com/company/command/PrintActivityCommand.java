package com.company.command;

import com.company.Customers;

public class PrintActivityCommand implements Command {

    Customers customers;

    public PrintActivityCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.PrintActivity();
    }
}